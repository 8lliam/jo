package modeles;

/**
 * @author Dane
 * @author William
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Sport implements Serializable {
	
	private static final long serialVersionUID = 1L;

	ArrayList<Epreuve> _sesEpreuves;
	private String _nomSport;
	private String _idSport;
	private static int _nbSport = 0;
	
	public Sport(String nomSport){
		_nomSport = nomSport;
		_idSport = Integer.toString(_nbSport);
		_nbSport++;
		_sesEpreuves = new ArrayList<Epreuve>();
	}

	public String get_nomSport() {
		return _nomSport;
	}

	public void set_nomSport(String _nomSport) {
		this._nomSport = _nomSport;
	}

	public String get_idSport() {
		return _idSport;
	}

	public void set_idSport(String _idSport) {
		this._idSport = _idSport;
	}

	public static int get_nbSport() {
		return _nbSport;
	}

	public static void set_nbSport(int _nbSport) {
		Sport._nbSport = _nbSport;
	}
	
    public void ajouterEpreuve(Epreuve e) {
    	_sesEpreuves.add(e);
    }

	public ArrayList<Epreuve> get_sesEpreuves() {
		return _sesEpreuves;
	}
	
	
	//methode ajouter epreuve

}