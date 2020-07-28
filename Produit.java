package Banque;

public class Produit {

	private long id_produit;
	private String nom;
	private int quantit�;
	private float prix;
	Commande commande;
	
	// CONSTRUCTEUR de l'objet PRODUIT
	public Produit(long id_produit, String nom, int quantit�, float prix) {
		super();
		this.id_produit = id_produit;
		this.nom = nom;
		this.quantit� = quantit�;
		this.prix = prix;
	}

	//	ACCESSEUR & MUTATEUR (getteur et setteur)
	public long getId_produit() {
		return id_produit;
	}

	public void setId_produit(long id_produit) {
		this.id_produit = id_produit;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	// TO STRING 
	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom=" + nom + ", quantit�=" + quantit� + ", prix=" + prix + "]";
	}
	
}
