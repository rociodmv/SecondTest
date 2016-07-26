package appli.test;

public class Singleton {
		
	//1. attribut priv� statique du type Singleton
	private static Singleton instance;

	//2. m�thode statique "getInstance" qui retorune l'attribut
	//   si l'attribut est null, cr�er l'instance
	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	//3.constructeur priv�
	private Singleton () {
		
	}
}
