package modeles;

/**
 * @author Dane
 * @author William
 */

import java.util.ArrayList;

public class EvenementIndividuelle extends Evenement implements Phase {

	private ArrayList <Athlete> _sesParticipants; 

	EvenementIndividuelle(EpreuveIndividuelle sonEpreuve, int phaseActuelle, int jour, int mois, ArrayList<Athlete> sesParticipants) {
		super(sonEpreuve, phaseActuelle, jour, mois);
		_sesParticipants = sesParticipants;
	}


	public EvenementIndividuelle(Epreuve sonEpreuve, int phaseActuelle, int jour, int mois, ArrayList<Athlete> sesParticipants, String description){
		super(sonEpreuve, phaseActuelle, jour, mois, description);
		_sesParticipants = sesParticipants;
	}


	public void set_sesParticipants(ArrayList<Athlete> _sesParticipants) {
		this._sesParticipants = _sesParticipants;
	}


	public ArrayList<Athlete> get_sesParticipants() {
		return (ArrayList<Athlete>) _sesParticipants;
	}


	public String getPhaseActuelle() {
		// TODO Auto-generated method stub
		return null;
	}



}