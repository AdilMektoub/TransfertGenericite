package Banque;

public class TestGenericite {

	public static void main(String[] args) {

		CompteGenericite<String> anisCompte = new CompteGenericite<String>("Anis", "15465", 800, "euros", 200);	
		CompteGenericite<Character> cidCompte =  new CompteGenericite<Character>("Cid", "545", 10000, '$', 500);

		CompteGenericite.transferer(100, cidCompte, anisCompte);
		
		anisCompte.decrire();
		cidCompte.decrire();
		
		char c='B'; // ASCII
        System.out.println((int) c); // ASCII
        System.out.println((char) 66); // ASCII
		
	}

}


