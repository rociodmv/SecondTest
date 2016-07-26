package appli.model;

import javax.faces.bean.ManagedBean;

@ManagedBean

public class Livre {
	
	//atributs
	private int id;
	private String titre, auteur, type;
	
	
	//getters et setters
	public String getTitre() {
		//System.out.println("getTitre");
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
		//System.out.println("setTitre");
		
	}
	public String getAuteur() {
		//System.out.println("getAuteur");
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
		//System.out.println("setAuteur");
	}

	public String getType() {
		//System.out.println("getType");
		return type;
	}
	public void setType(String type) {
		this.type = type;
		//System.out.println("setType");
	}
	
	public int getId() {
		//System.out.println("getId");
		return id;
	}
	public void setId(int id) {
		this.id = id;
		//System.out.println("setId");
	}
	//constructeur
	public Livre(int id, String titre, String auteur, String type) {
		System.out.println("constructor working");
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.type = type;
		//System.out.println("getTitre");
	}
	public Livre() {
		super();
		//System.out.println("default constructor working");
	}
	
	@Override
	public String toString() {
		return "Livre [id=" + id + ", Titre=" + titre + ", Auteur="
				+ auteur + ", Genre=" + type + "]";
	}

}
