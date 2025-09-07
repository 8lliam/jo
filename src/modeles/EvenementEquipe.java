package modeles;

/**
 * @author Dane
 * @author William
 */

public class EvenementEquipe extends Evenement implements Phase   {

	private Equipe[] _sesEquipes; // Tableau des équipes participant à l'événement
	
	/**
	 * 
	 * @param sonEpreuve
	 * @param phaseActuelle
	 * @param jour
	 * @param mois
	 * @param _sesEquipes
	 */
	// Constructeur de la classe EvenementEquipe
	EvenementEquipe(EpreuveEquipe sonEpreuve, int phaseActuelle, int jour, int mois, Equipe [] _sesEquipes) {
		super(sonEpreuve, phaseActuelle, jour, mois);
		_sesEquipes = _sesEquipes;
	}
	
	/**
	 * 
	 * @param sonEpreuve
	 * @param phaseActuelle
	 * @param jour
	 * @param mois
	 * @param _sesEquipes
	 * @param description
	 */
	
	// Surcharge du constructeur pour inclure une description
	EvenementEquipe(EpreuveEquipe sonEpreuve, int phaseActuelle, int jour, int mois, Equipe [] _sesEquipes, String description) {
		super(sonEpreuve, phaseActuelle, jour, mois, description);
		_sesEquipes = _sesEquipes;
	}

	public Equipe[] get_sesEquipes() {
		return _sesEquipes;
	}
}