package appli.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

import appli.database.LivreDAO;
import appli.database.LivreService;
import appli.model.Livre;

@ManagedBean (name = "livreContr")
@SessionScoped
public class livreController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// attribut
	private Livre livre;
	private List<Livre> listLiv;
	private LivreDAO livreDao;
	private LivreService livreServ;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// getter et setter
	
	public void setTitre(String Titre){
		this.livre.setTitre(Titre);
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public List<Livre> getListLiv() {
		return listLiv;
	}

	public void setListLiv(List<Livre> listLiv) {
		this.listLiv = listLiv;
	}

	public LivreService getLivreServ() {
		return livreServ;
	}

	public void setLivreServ(LivreService livreServ) {
		this.livreServ = livreServ;
	}

	public void setAuteur(String auteur){
		this.livre.setAuteur(auteur);
	}

	public void setType(String type){
		this.livre.setType(type);
	}

	public livreController(Livre livre, List<Livre> listLiv, LivreService livreServ, Logger logger) {
		super();
		this.livre = livre;
		this.listLiv = listLiv;
		this.livreServ = livreServ;
		this.logger = logger;
	}

	/*
	 * public livreController() { //pour le faire à la main 
	 * super();
	 * listLiv.add(new Livre("Neverending Story", "M. Ende", "Aventure"));
	 * listLiv.add(new Livre("Ma thèse", "R. de Miguel", "Science"));
	 * listLiv.add(new Livre("1080 Recettes", "S. Ortega", "Cuisine")); }
	 */


	
	// pour récupérer mes éléments directs de la bd
	public livreController() throws Exception {
	
			listLiv = new ArrayList<>();
			livreDao = LivreDAO.getInstance();	}

	
	// méthode pour ajouter un livre depuis mon formulaire
	
	public String addLivre(Livre newLivre) throws Exception, Exception {
		
		//on va appeller la méthode de la couche service
		livreServ.addLivre(newLivre);
		
		
		return "listeLivres";
	}

	

	@Override
	public String toString() {
		return "livreController [livre=" + livre + ", listLiv=" + listLiv + ", livreDao=" + livreServ + ", logger="
				+ logger + "]";
	}
	
}