package modeles;

import java.io.*;

public class Athlete implements Serializable {

    private static final long serialVersionUID = 1L;

    Nation _saNation; // La nation à laquelle appartient l'athlète
    Equipe[] _sesParticipationsEnEquipe; // Les équipes auxquelles l'athlète a participé
    EpreuveIndividuelle[] _sesParticipations; // Les épreuves individuelles auxquelles l'athlète a participé
    private String _nomAthlete; // Le nom de l'athlète
    private String _prenomAthlete; // Le prénom de l'athlète
    private int _ageAthlete; // L'âge de l'athlète
    private static int _nbAthlete; // Le nombre total d'athlètes
    private String _idAthlete; // L'identifiant de l'athlète

    // La taille de l'athlète en centimètres
    private int _tailleAthlete;
    private double _poidsAthlete; // Le poids de l'athlète

    // Le genre de l'athlète : soit H (Homme), F (Femme), NR (Non Renseigné)
    private String _genreAthlete;
    /**
     
@param nomAthlete
@param prenomAthlete
@param ageAthlete
@param genreAthlete
*/
// Constructeur pour initialiser un nouvel athlète
public Athlete(String nomAthlete, String prenomAthlete, int ageAthlete, String genreAthlete) {_nomAthlete = nomAthlete;_prenomAthlete = prenomAthlete;_ageAthlete = ageAthlete;_genreAthlete = genreAthlete;_idAthlete = Integer.toString(_nbAthlete);_nbAthlete++;}


}