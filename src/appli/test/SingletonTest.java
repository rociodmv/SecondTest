package appli.test;

public class SingletonTest {

	public static void main(String[] args) {
		//ATTENTION - dans projets web, pour lancer une classe main java: "run as Java Application"
		// l'interet du singleton dans ce cas, c'est de recuperer toujours la meme instance
		
		//ex 1 - pas d'instance
		Singleton s1 = Singleton.getInstance();
		System.out.println("Ex1. nouvelle instance " + s1); //imprime l'instance qu'on a cr��
		
		//ex 2 - r�cup�ration de l'instance qu'on a d�j� cr�e dans l'ex 1
		Singleton s2 = Singleton.getInstance();
		System.out.println("Ex2. instance du Ex.1 " + s2);
		

	}

}
