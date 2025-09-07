
package modeles;

import vues.PanelAjouterSession;

/**
 * @author Dane
 * @author Marc
 * @author William
 */

public class Session implements Phase {

    private Epreuve[] _epreuvesProposes;
   
    private String _codeSession;
    private static int _nbSession = 0;
    private String _descriptionSession;

    // Pour la date faut voir par rapport au planning
    private String _dateSession;
    // Pour les horaires pareil que les dates. Là il faudrait un format qui sera respecté partout.
    private String _heureSessionDebut;
    private String _minuteSessionDebut;
    private String _horraireSessionDebut;
    private String _heureSessionFin;
    private String _minuteSessionFin;
    private String _horraireSessionFin;
    private int _nbEpreuves;
    private static final int MAX_EPREUVES = 100;

    public Session(String dateSession, String heureSessionDebut, String minuteSessionDebut, String heureSessionFin, String minuteSessionFin) {
        _codeSession = Integer.toString(_nbSession);
        _nbSession++;
        _dateSession = dateSession;
        _heureSessionDebut = heureSessionDebut;
        _minuteSessionDebut = minuteSessionDebut;
        _heureSessionFin = heureSessionFin;
        _minuteSessionFin = minuteSessionFin;
        set_horraireSessionDebut();
        set_horraireSessionFin();
        _epreuvesProposes = new Epreuve[MAX_EPREUVES];
        _nbEpreuves = 0;
    }


    public String get_codeSession() {
        return _codeSession;
    }

    public void set_codeSession(String _codeSession) {
        this._codeSession = _codeSession;
    }

    public String get_descriptionSession() {
        return _descriptionSession;
    }

    public void set_descriptionSession(String _descriptionSession) {
        this._descriptionSession = _descriptionSession;
    }

    public String get_dateSession() {
        return _dateSession;
    }

    public void set_dateSession(String _dateSession) {
        this._dateSession = _dateSession;
    }

    public String get_horraireSessionDebut() {
        return _horraireSessionDebut;
    }

    public void set_horraireSessionDebut() {
        this._horraireSessionDebut = _heureSessionFin + " h " + _minuteSessionFin;
    }

    public String get_heureSessionDebut() {
        return _heureSessionDebut;
    }

    public void set_heureSessionDebut(String _heureSessionDebut) {
        this._heureSessionDebut = _heureSessionDebut;
    }

    public String get_minuteSessionDebut() {
        return _minuteSessionDebut;
    }

    public void set_minuteSessionDebut(String _minuteSessionDebut) {
        this._minuteSessionDebut = _minuteSessionDebut;
    }

    public String get_heureSessionFin() {
        return _heureSessionFin;
    }

    public void set_heureSessionFin(String _heureSessionFin) {
        this._heureSessionFin = _heureSessionFin;
    }

    public String get_minuteSessionFin() {
        return _minuteSessionFin;
    }

    public void set_minuteSessionFin(String _minuteSessionFin) {
        this._minuteSessionFin = _minuteSessionFin;
    }

    public String get_horraireSessionFin() {
        return _horraireSessionFin;
    }

    public void set_horraireSessionFin() {
        this._horraireSessionFin = _heureSessionFin + " h " + _minuteSessionFin;
    }
    // Getters and setters for date, titre, heureDebut, heureFin

    public void ajouterEpreuve(Epreuve epreuve) {
        if (_nbEpreuves < MAX_EPREUVES) {
            _epreuvesProposes[_nbEpreuves] = epreuve;
            _nbEpreuves++;
        } else {
            System.out.println("Limite d'épreuves atteinte pour cette session.");
        }
    }
//    public void supprimerEpreuve(String epreuve) {
//        Epreuve.remove(epreuve);
//    }

    public String[] getNomsEpreuvesProposees() {
        String[] nomsEpreuves = new String[_nbEpreuves];
        for (int i = 0; i < _nbEpreuves; i++) {
            nomsEpreuves[i] = _epreuvesProposes[i].getNomEpreuve();
        }
        return nomsEpreuves;
    }
    
    
    // Méthode pour ajouter une épreuve à la session

    

    // Ajoutez cette méthode pour permettre à la vue de mettre à jour la liste des épreuves proposées
    		public void mettreAJourListeEpreuvesProposees(PanelAjouterSession vue) {
        vue.updateSourceListFromModele();
    }

			public void setHeureDebut(String string) {
				// TODO Auto-generated method stub
				
			}

			public void setHeureFin(String string) {
				// TODO Auto-generated method stub
				
			}
    		
 

}
