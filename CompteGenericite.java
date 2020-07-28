package Banque;

public class CompteGenericite<T> {

	private String client;
	private String numeroCompte;
	private double solde;
	private T devise;
	private double decouvert;


	public CompteGenericite(String client, String numeroCompte, double solde, 
			T devise, double decouvert) {
		this.client = client;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
		this.devise = devise;
		this.decouvert = decouvert;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public void decrire() {
		System.out.println(this.client + " possede "+ this.solde + " " + this.devise + " sur son compte bancaire");
	}

	public void ajouter(double montant) {
		this.solde = this.solde + montant;
		System.out.println(this.client + " a ajouter " + montant + " et son solde = "+ this.solde);
	}

	public void retirer(double montant) {
		if ( montant <= this.solde + this.decouvert) {
			this.solde = this.solde - montant;
			System.out.println(this.client + " a retirer " + montant + " et son solde = "+ this.solde);
		} else System.out.println("le solde de "+this.client+" est insuffisant");
	}

	public static <T, S> void transferer(double montant, CompteGenericite<T> envoyeur, 
			CompteGenericite<S> beneficiaire) { 
		if (((String) envoyeur.getDevise()).equalsIgnoreCase("euro") ||
				((String) envoyeur.getDevise()).equalsIgnoreCase("euros")	||
				((Character) envoyeur.getDevise() == '€')) {
			System.out.println("la devise de l'envoyeur est l'€");
		}
		if ( montant <= envoyeur.getSolde() + envoyeur.getDecouvert()) {
			envoyeur.retirer(montant);
			beneficiaire.ajouter(montant);
		}
		else System.out.println(envoyeur.client + " n'a pas assez d'argent");
}
	
	
	

	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getNumeroCompte() {
		return numeroCompte;
	}
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public T getDevise() {
		return devise;
	}
	public void setDevise(T devise) {
		this.devise = devise;
	}


//	public static void transferer(double montant, Compte envoyeur, Compte beneficiaire) {
//		if (envoyeur.getDevise() == beneficiaire.getDevise()) {
//			
//			if ( montant <= envoyeur.getSolde() + envoyeur.getDecouvert()) {
//				envoyeur.retirer(montant);
//				beneficiaire.ajouter(montant);
//			}
//			else System.out.println(envoyeur.client + " n'a pas assez d'argent");
//		}
//		else {
//			if (envoyeur.getDevise() == '$') {
//				if ( montant <= envoyeur.getSolde() * 0.9 + envoyeur.getDecouvert() * 0.9 ) {
//					envoyeur.retirer(montant);
//					beneficiaire.ajouter(montant * 0.9);
//				}
//				else System.out.println(envoyeur.client + " n'a pas assez d'argent");
//			}
//			else {
//				if ( montant <= envoyeur.getSolde() * 1.11 + envoyeur.getDecouvert() * 1.11 ) {
//					envoyeur.retirer(montant);
//					beneficiaire.ajouter(montant * 1.11);
//				}
//				else System.out.println(envoyeur.client + " n'a pas assez d'argent");
//			}
//		}
//	}
	

}
