package appli.database;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import appli.model.Livre;

public class LivreService {

	// attributes
	private LivreDAO livreDao;
	private Livre livre;
	private List<Livre> listLiv;

	// méthodes

	// pour récupérer mes éléments directs de la bd
	


	// pour ajouter un livre (je le prends du controller)
	public String addLivre(Livre theLivre) {

		//logger.info("Adding book: " + theLivre);

		try {

			// add student to the database
			// System.out.println("je suis dans le try");
			livreDao.getInstance().addLivre(theLivre);
			// System.out.println("the livre added");

		} catch (Exception exc) {

			// send this to server logs
			//logger.log(Level.SEVERE, "Error adding books", exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "listeLivres";
	}

	private void addErrorMessage(Exception exc) {

	}

	


}
