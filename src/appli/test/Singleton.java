package appli.test;

public class Singleton {
		
	//1. attribut privé statique du type Singleton
	private static Singleton instance;

	//2. méthode statique "getInstance" qui retorune l'attribut
	//   si l'attribut est null, créer l'instance
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//3.constructeur privé
	private Singleton () {
		
	}
}
