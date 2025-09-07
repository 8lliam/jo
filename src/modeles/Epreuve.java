package modeles;

import java.io.Serializable;

/**
 * @author Dane
 * @author William
 */

public abstract class Epreuve implements Phase, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Sport sonSport;// Le sport associé à cette épreuve
	private Session saSession; // La session associée à cette épreuve
	private String nomEpreuve;// Le nom de l'épreuve
	private String lieuEpreuve;// Le lieu où se déroule l'épreuve
	//pour faciliter le planning
	private int jourDebutEpreuve;
	private int moisDebutEpreuve;
	private int jourFinEpreuve;
	private int moisFinEpreuve;
	private String dateDebut;
	private String dateFin;
	protected int nbEvenements;
	private int statutEpreuve;
	public int nbmaxparticipants;
	
	
	/**
	 * 
	 * @param nomSport
	 * @param nomEpreuve
	 * @param lieuEpreuve
	 * @param jourDebutEpreuve
	 * @param moisDebutEpreuve
	 * @param jourFinEpreuve
	 * @param moisFinEpreuve
	 */
	// Constructeur de la classe Epreuve
	Epreuve (Sport nomSport, String nomEpreuve, String lieuEpreuve, int jourDebutEpreuve, int moisDebutEpreuve, int jourFinEpreuve, int moisFinEpreuve){
		this.sonSport = nomSport;
		this.nomEpreuve = nomEpreuve;
		this.lieuEpreuve = lieuEpreuve;
		this.jourDebutEpreuve = jourDebutEpreuve;
		this.moisDebutEpreuve = moisDebutEpreuve;
		this.jourFinEpreuve = jourFinEpreuve;
		this.moisFinEpreuve = moisFinEpreuve;
		setDateDebut();
		setDateFin();
	}
	
	
	
	
	/* -------------------------------Methodes-------------------------------- */
	// Méthode pour modifier les informations d'une épreuve
	void modifierEpreuve(String nomEpreuve, String lieuEpreuve, int jourDebutEpreuve, int moisDebutEpreuve, int statutEpreuve) {
		setNomEpreuve(nomEpreuve);
		setLieuEpreuve(lieuEpreuve);
		setJourDebutEpreuve(jourDebutEpreuve);
		setMoisDebutEpreuve(moisDebutEpreuve);
		setDateDebut();
		setStatutEpreuve(statutEpreuve);
	}

	// Méthode pour vérifier si l'épreuve est terminée
	boolean verifierEpreuveTerminer() {
		boolean resultat = false;
		// Logique de vérification à implémenter
		return resultat;
	}
	
//	abstract void creerEvenement(int phase);
	
	
	
	/* -------------------------------Accesseurs-------------------------------- */

	public String getNomEpreuve() {
		return nomEpreuve;
	}

	public void setNomEpreuve(String nomEpreuve) {
		this.nomEpreuve = nomEpreuve;
	}

	public String getLieuEpreuve() {
		return lieuEpreuve;
	}

	public void setLieuEpreuve(String lieuEpreuve) {
		this.lieuEpreuve = lieuEpreuve;
	}

	public int getJourDebutEpreuve() {
		return jourDebutEpreuve;
	}

	public void setJourDebutEpreuve(int jourDebutEpreuve) {
		this.jourDebutEpreuve = jourDebutEpreuve;
	}

	public int getMoisDebutEpreuve() {
		return moisDebutEpreuve;
	}

	public void setMoisDebutEpreuve(int moisDebutEpreuve) {
		this.moisDebutEpreuve = moisDebutEpreuve;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut() {
		this.dateDebut = jourDebutEpreuve + "/"+ moisDebutEpreuve;
	}
	
	public String getDateFin() {
		return dateDebut;
	}

	public void setDateFin() {
		this.dateDebut = jourFinEpreuve + "/"+ moisFinEpreuve;
	}
	
	public int getStatutEpreuve() {
		return statutEpreuve;
	}

	public void setStatutEpreuve(int statutEpreuve) {

		this.statutEpreuve = statutEpreuve;
	}
	
	
	


	
	
}