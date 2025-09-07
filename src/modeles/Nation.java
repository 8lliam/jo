package modeles;

/**
 * @author Dane
 * @author William
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Nation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	ArrayList<Athlete> _sesAthletes;
	ArrayList<Equipe> _sesEquipes;
	private String _nomNation;
	private String _idNation;
	private static int _nbNation = 0;

	public Nation(String nomNation) {
		_nomNation = _nomNation;
		_idNation = Integer.toString(_nbNation);
		_nbNation++;

	}

	
	
	//methodes pour ajouter et supprimer athlete
	//pareil pour les equipes (mais verif que les athlètes appartienne à la nation)
	
	
	
	
	/*-------------------------------ACCESSEURS------------------------------*/
	
	public String get_idNation() {
		return _idNation;
	}
	
	public int get_sesEquipesSize() {
		return _sesEquipes.size();
	}
}