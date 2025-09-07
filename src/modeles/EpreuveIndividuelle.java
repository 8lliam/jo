package modeles;

import java.util.ArrayList;

/**
 * @author Dane
 * @author William
 */

public class EpreuveIndividuelle extends Epreuve {

    private ArrayList<Athlete> _sesParticipants;
    private int _nbAthlete;
    private int nbParticipantMax;
    private EvenementIndividuelle[] _sesEvenements;
    private int nbEvenements;
    private int phase;

    /**
     * 
     * @param nomSport
     * @param nomEpreuve
     * @param lieuEpreuve
     * @param jourDebutEpreuve
     * @param moisDebutEpreuve
     * @param jourFinEpreuve
     * @param moisFinEpreuve
     * @param sesParticipants
     * @param nbParticipantMax
     * @param phase
     */
    // Constructeur de la classe EpreuveIndividuelle
    public EpreuveIndividuelle(Sport nomSport, String nomEpreuve, String lieuEpreuve, int jourDebutEpreuve, int moisDebutEpreuve, 
            int jourFinEpreuve, int moisFinEpreuve, ArrayList<Athlete> sesParticipants, int nbParticipantMax, int phase) {
        super(nomSport, nomEpreuve, lieuEpreuve, jourDebutEpreuve, moisDebutEpreuve, jourFinEpreuve, moisFinEpreuve);
        this.nbEvenements = 0;
        this._nbAthlete = 0;
        this.nbParticipantMax = nbParticipantMax;
        this._sesParticipants = sesParticipants;
        this._sesEvenements = new EvenementIndividuelle[10];  // Initialisation du tableau avec 10 événements max
        this.phase = phase;
    }



	public int get_nbAthlete() {
        return _nbAthlete;
    }

    public void set_nbAthlete() {
        this._nbAthlete = _sesEvenements.length;
    }

    // Méthode pour créer un événement individuel
    public void creerEvenement(int phase) {
        EvenementIndividuelle evenement = new EvenementIndividuelle(this, phase, 1, 2, _sesParticipants, "Description de l'événement");
        ajouterEvenement(evenement);
    }

    // Méthode pour ajouter un événement à la liste des événements
    public void ajouterEvenement(EvenementIndividuelle evenement) {
        if (nbEvenements < _sesEvenements.length) {
            _sesEvenements[nbEvenements] = evenement;
            nbEvenements++;
        }
    }
    
    
    public EvenementIndividuelle[] getSesEvenements() {
        return _sesEvenements;
    }
}
