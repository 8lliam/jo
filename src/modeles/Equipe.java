package modeles;

import java.io.Serializable;

/**
 * @author Dane
 * @author William
 */

public class Equipe implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Nation _saNation; // La nation à laquelle l'équipe appartient
	Athlete[] _composition; // Les athlètes qui composent l'équipe
	EpreuveEquipe[] _leursParticipations;// Les participations de l'équipe aux épreuves
	private String _nomEquipe;// Le nom de l'équipe
	private String _idEquipe;// L'identifiant unique de l'équipe
	
	/**
	 * 
	 * @param saNation
	 * @param nomEquipe
	 */
	// Constructeur de la classe Equipe
	Equipe(Nation saNation, String nomEquipe){
		_saNation = saNation;
		_nomEquipe = nomEquipe;
		// Identifiant de la Nation + l'identifiant de l'équipe obtenu via la classe nation
		_idEquipe = saNation.get_idNation() + Integer.toString(saNation.get_sesEquipesSize()); 
		
		// Ensuite, ajouter l'équipe dans la liste d'équipes de la nation (saNation)
	}
	
}