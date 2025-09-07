package modeles;

import java.io.Serializable;

/**
 * @author Dane
 * @author William
 */

public abstract class Evenement implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Epreuve _sonEpreuve; // L'épreuve associée à cet événement
	int _jour; // Le jour de l'événement
	int _mois; // Le mois de l'événement
	int _statut; // Le statut ou phase actuelle de l'événement
	String _description; // La description de l'événement
	
	/**
	 * 
	 * @param sonEpreuve
	 * @param phaseActuelle
	 * @param jour
	 * @param mois
	 */
	// Constructeur de la classe Evenement
	Evenement(Epreuve sonEpreuve, int phaseActuelle, int jour, int mois){
		_sonEpreuve = sonEpreuve;
		_statut = phaseActuelle;
		_jour = jour;
		_mois = mois;
	}
	
	/**
	 * 
	 * @param sonEpreuve
	 * @param phaseActuelle
	 * @param jour
	 * @param mois
	 * @param description
	 */
	// Surcharge du constructeur pour inclure une description
	Evenement(Epreuve sonEpreuve, int phaseActuelle, int jour, int mois, String description){
		_sonEpreuve = sonEpreuve;
		_statut = phaseActuelle;
		_jour = jour;
		_mois = mois;
		_description = description;
	}
	
	/*---------------------------------Accesseurs----------------------------------------*/


	public Epreuve get_sonEpreuve() {
		return _sonEpreuve;
	}

	public void set_sonEpreuve(Epreuve _sonEpreuve) {
		this._sonEpreuve = _sonEpreuve;
	}

	public int get_jour() {
		return _jour;
	}

	public void set_jour(int _jour) {
		this._jour = _jour;
	}

	public int get_mois() {
		return _mois;
	}

	public void set_mois(int _mois) {
		this._mois = _mois;
	}

	public int get_statut() {
		return _statut;
	}

	public void set_phaseActuelle(int statut) {
		this._statut = statut;
	}

	
	public String get_description() {
		return _description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}
	
	/*---------------------------------Accesseurs----------------------------------------*/
	
	
}
