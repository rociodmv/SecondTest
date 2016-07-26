package appli.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import appli.model.Livre;

public class LivreDAO { // elle nous permet de nous connecter à la base de
						// données

	private static LivreDAO instance; // singleton
	// pour acceder à la base de données
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/livres";

	// getInstance du singleton
	public static LivreDAO getInstance() throws NamingException {
		if (instance == null) {
			instance = new LivreDAO();
		}
		return instance;
	}

	// constructeur privé du singleton
	private LivreDAO() throws NamingException {
		dataSource = getDataSource();
	}

	// méthode getDataSource
	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();

		DataSource theDatasource = (DataSource) context.lookup(jndiName);

		return theDatasource;
	}

	// récuperation de la liste des livres de ma DB
	public List<Livre> getLivre() throws Exception {

		List<Livre> listLivre = new ArrayList<Livre>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			myConn = dataSource.getConnection();

			String sql = "select * from livre;";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				
				int id = myRs.getInt("id");
				String titre = myRs.getString("titre");
				String auteur = myRs.getString("auteur");
				String type = myRs.getString("type");

				// nouveau objet livre
				Livre newlivre = new Livre(id, titre, auteur, type);

				// ajout à la liste de livres de ma base de données
				listLivre.add(newlivre);

			}

			return listLivre;

		} 
	finally {
	close (myConn, myStmt, myRs);
	}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException {
	myConn.close();
	myStmt.close();
	myRs.close();
		
	}

	// méthode ajouter un livre
	public void addLivre(Livre newLivre) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			//System.out.println("tryDAO");
			myConn = dataSource.getConnection();
			//System.out.println("connecté");

			String sql = "insert into livre (titre, auteur, type) values (?, ?, ?)";
			//System.out.println("INSERT INTO LIVRE FAIT");

			myStmt = myConn.prepareStatement(sql);

			//System.out.println("prepareStatement fait");
			
			// set parametres
			myStmt.setString(1, newLivre.getTitre());
			myStmt.setString(2, newLivre.getAuteur());
			myStmt.setString(3, newLivre.getType());
			//System.out.println("set string fait");
			
			myStmt.execute();
			//System.out.println("statement exécuté");
			
		} 
			finally {
			close(myConn, myStmt);
		}

	}

	private Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	private void close(Connection myConn, PreparedStatement myStmt) {

	}

}
