package modeles;

/**
 * @author Dane
 * @author William
 */

public class EpreuveEquipe extends Epreuve {

	private Equipe[] _sesEquipes; // Tableau des équipes participant à l'épreuve
	private EvenementEquipe[] _sesEvenements; // Tableau des événements associés à cette épreuve
	private int _nbEvenement; // Nombre d'événements associés à cette épreuve
	private int _nbEquipe; // Nombre d'équipes actuellement inscrites à cette épreuve
	private int _nbEquipeMax; // Nombre maximum d'équipes pouvant participer à cette épreuve
	
	
	/**
	 * 
	 * @param nomSport
	 * @param nomEpreuve
	 * @param lieuEpreuve
	 * @param jourDebutEpreuve
	 * @param moisDebutEpreuve
	 * @param jourFinEpreuve
	 * @param moisFinEpreuve
	 * @param sesEquipes
	 * @param nbEquipeMax
	 */
	
	// Constructeur de la classe EpreuveEquipe
	EpreuveEquipe(Sport nomSport, String nomEpreuve, String lieuEpreuve, int jourDebutEpreuve, int moisDebutEpreuve,
				  int jourFinEpreuve, int moisFinEpreuve, Equipe[] sesEquipes, int nbEquipeMax) {
		super(nomSport, nomEpreuve, lieuEpreuve, jourDebutEpreuve, moisDebutEpreuve, jourFinEpreuve, moisFinEpreuve);
		_nbEquipe = 0;
		this._nbEvenement = 0;
		this._nbEquipeMax = nbEquipeMax;
		this._sesEquipes = sesEquipes;
	}

	// Getter pour obtenir le nombre d'équipes inscrites
	public int get_nbEquipe() {
		return _nbEquipe;
	}

	// Setter pour mettre à jour le nombre d'équipes inscrites en fonction du nombre d'événements
	public void set_nbEquipe() {
		this._nbEquipe = _sesEvenements.length;
	}

// Méthode pour créer un événement (à décommenter et implémenter si nécessaire)
//	@Override
//	void creerEvenement(int phase) {
//		// si c'est une phase finale, il faut vérifier certains critères
//		// par exemple, si c'est de type
//		EvenementEquipe evenement = new EvenementEquipe();
//	}
}
