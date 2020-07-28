package Banque;

public class Compte {

	int numero;
	float solde;
	char devise;
	Utilisateur utilisateur;
	float decouvert;
	
	
	// Constructeurs de l'objets COMPTE
	public Compte(int numero, float solde, char devise, Utilisateur utilisateur, float decouvert) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.devise = devise;
		this.utilisateur = utilisateur;
		this.decouvert = decouvert;
		
	}

	// rajout des toString
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + ", devise=" + devise + ", user=" + utilisateur
				+ ", decouvert=" + decouvert + "]";
	}

	// rajout des acesseurs et mutateurs (geteurs/seteurs)
	public int getNumero() {
		return numero;
	}

	public float getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}

	public float getSolde() {
		return solde;
	}

	public char getDevise() {
		return devise;
	}

	public Utilisateur getUser() {
		return utilisateur;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public void setDevise(char devise) {
		this.devise = devise;
	}

	public void setUser(Utilisateur user) {
		this.utilisateur = user;
	}

	// M�thode qui va permettre de transf�rer
	static void transferer(Compte emmetteur, Compte destinataire, float montant) {
		boolean possible = false;
		if ((emmetteur.getDevise() != '�' && emmetteur.getDevise() != '$') || 		// SI devise emmeteur est diff�rent de � et $
				(destinataire.getDevise() != '�' && destinataire.getDevise() != '$')	) {		// OU devise destinataire diff�rent de � et $
			System.out.println("une ou les 2 devises ne sont pas pris en compte !");	// ALORS �crit 
		}
		else {	// SINON 		
			if (emmetteur.getSolde() + emmetteur.getDecouvert() > montant)		// SI solde et decouvert emmetteur SUPERIEUR au montant 
				possible = true;												// c'est possible (oui)
			else 	System.out.println("Le solde de " + emmetteur.getUser().getNom() + " est insuffisant"); //SINON �crit 
			
			if (possible) {														// c'est possible 
				if (emmetteur.getDevise() == '�' && destinataire.getDevise()=='$') {	// SI la devise de l'emmetteur � et la devise du destinataire $
					emmetteur.retirer(montant);										// tu retires le montant � l'emmetteur
					montant = (float) (montant * 1.14);								// tu le multiplie pas sont prix en Dollar (change)
					destinataire.alimenter(montant);								// tu rajoute ce montant convertie chez le Destinataire
				}
				else if (emmetteur.getDevise() == '$' && destinataire.getDevise()=='�') {	//SINON SI la devise de l'emmetteur $ et la devise du destinataire �
					emmetteur.retirer(montant);												// tu retires le montant � l'emmetteur
					montant = (float) (montant * 0.88);										// tu le multiplie pas sont prix en Euros (change)
					destinataire.alimenter(montant);										// tu le rajoutes chez le destinataire
				}		
				else if (emmetteur.getDevise() == destinataire.getDevise()) {		//SINON SI la devise de l'emmetteur est �gale � la devise du destinataire
					emmetteur.retirer(montant);										// tu retires ce montant � l'emmetteur SANS CONVERTIONS car les devises sont les m�mes
					destinataire.alimenter(montant);								// tu le rajoutes au destinataire
				}
			}
		}
	}

	//M�thode qui va permettre d'alimenter le montant au compte
	public void alimenter(float montant) {
		this.setSolde(montant + this.getSolde());
	}

	//M�thode qui va permettre de retirer le montant du compte
	public void retirer(float montant) {
		this.setSolde(this.getSolde() - montant);
	}
	
	//M�thode permettant que l'�mmetteur choississent sa devise (SURCHARGE = OVERLOADING)
static void transferer(Compte emmetteur, Compte destinataire, float montant, char deviseDeMontant) {
		
		boolean possible = false;
		if ((emmetteur.getDevise() != '�' && emmetteur.getDevise() != '$') ||
				(destinataire.getDevise() != '�' && destinataire.getDevise() != '$') ||
				(deviseDeMontant != '�' && deviseDeMontant != '$')) {
			System.out.println("une ou les 3 devises ne sont pas pris en compte !");
		}
		else if (emmetteur.getDevise() != deviseDeMontant) {
			if (deviseDeMontant == '$') {
				montant = (float) (montant * 0.88);
				if (emmetteur.getSolde() + emmetteur.getDecouvert() > montant)
					possible = true;
				else 	System.out.println("Le solde de " + emmetteur.getUser().getNom() + " est insuffisant");
			}
			else if (deviseDeMontant == '�') {
				montant = (float) (montant * 1.14);
				if (emmetteur.getSolde() + emmetteur.getDecouvert() > montant)
					possible = true;
				else 	System.out.println("Le solde de " + emmetteur.getUser().getNom() + " est insuffisant");
			}
		}
		else if (emmetteur.getDevise() == deviseDeMontant ) {
			if (emmetteur.getSolde() + emmetteur.getDecouvert() > montant)
				possible = true;
			else 	System.out.println("Le solde de " + emmetteur.getUser().getNom() + " est insuffisant");
		}
		if (possible) {
			if (emmetteur.getDevise() == '�' && destinataire.getDevise()=='$') {
				emmetteur.retirer(montant);
				montant = (float) (montant * 1.14);
				destinataire.alimenter(montant);
			}
			else if (emmetteur.getDevise() == '$' && destinataire.getDevise()=='�') {
				emmetteur.retirer(montant);
				montant = (float) (montant * 0.88);
				destinataire.alimenter(montant);
			}		
			else if (emmetteur.getDevise() == destinataire.getDevise()) {
				emmetteur.retirer(montant);
				destinataire.alimenter(montant);
			}
		}
	}

//Si ajout une commande et passage commande retirer montant du solde du compte
}
