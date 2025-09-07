package controleurs;

import modeles.*;
import vues.Data;
import vues.PanelEpreuve;
import vues.VueEpreuveSport;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author William
 */

public class EcouteurGererEpreuve implements ActionListener{

    private PanelEpreuve panelEpreuve;
    
    // Déclarations des champs nécessaires pour créer une nouvelle épreuve
    public String _nomSport;
    public JTextField _tfNomEpreuve;
    public JTextField _tfJourDebut;
    public JTextField _tfMoisDebut;
    public JTextField _tfJourFin;
    public JTextField _tfMoisFin;
    public JTextField _tfLieuEpreuve;
    public JTextField _tfNbParticipantsMax;
    public JComboBox<String> _comboBoxGenre;
    public JComboBox<String> _comboBoxStatut;
    public ArrayList<Athlete> _lstAthelte;
    private JPanel cards;
    private CardLayout cardLayout;

    /**
     * 
     * @param nomSport
     * @param tfNomEpreuve
     * @param tfJourDebut
     * @param tfMoisDebut
     * @param tfJourFin
     * @param tfMoisFin
     * @param tfLieuEpreuve
     * @param tfNbParticipantsMax
     * @param comboBoxGenre
     * @param comboBoxStatut
     */
    // Constructeur
    public EcouteurGererEpreuve(String nomSport, JTextField tfNomEpreuve, JTextField tfJourDebut, JTextField tfMoisDebut, JTextField tfJourFin, 
    		JTextField tfMoisFin, JTextField tfLieuEpreuve, JTextField tfNbParticipantsMax, JComboBox<String> comboBoxGenre,
            JComboBox<String> comboBoxStatut,JPanel cards, CardLayout cardLayout) 
    	{
    		_nomSport = nomSport;
			_tfNomEpreuve = tfNomEpreuve;
			_tfJourDebut = tfJourDebut;
			_tfMoisDebut = tfMoisDebut;
			_tfJourFin = tfJourFin;
			_tfMoisFin = tfMoisFin;
			_tfLieuEpreuve = tfLieuEpreuve;
			_tfNbParticipantsMax = tfNbParticipantsMax;
			_comboBoxGenre = comboBoxGenre;
			_comboBoxStatut = comboBoxStatut;
			
			_lstAthelte = new ArrayList<Athlete>();
    }

    // Méthode qui sera appelée lorsque l'action est déclenchée (par exemple, un clic sur un bouton)
	@Override
	public void actionPerformed(ActionEvent e) {
        // Création d'une instance de Data pour rechercher le sport correspondant
		Data donnee = new Data();
		Sport sport = donnee.chercherSport(_nomSport);
        // Récupération des valeurs des champs de texte et des sélections de la combobox
		String nomEpreuve = _tfNomEpreuve.getText();
        String lieuEpreuve = _tfLieuEpreuve.getText();
        int jourDebut = Integer.parseInt(_tfJourDebut.getText());
        int moisDebut = Integer.parseInt(_tfMoisDebut.getText());
        int jourFin = Integer.parseInt(_tfJourFin.getText());
        int moisFin = Integer.parseInt(_tfMoisFin.getText());
        int nbParticipantsMax = Integer.parseInt(_tfNbParticipantsMax.getText());
        int statutEpreuve = _comboBoxStatut.getSelectedIndex();
        // Création de la nouvelle épreuve individuelle
        String genre = _comboBoxStatut.getSelectedItem().toString();
        
        Epreuve nouvelleEpreuve;
        nouvelleEpreuve = new EpreuveIndividuelle(sport, nomEpreuve, lieuEpreuve, jourDebut, moisDebut, jourFin, moisFin,_lstAthelte, nbParticipantsMax, statutEpreuve);
        sport.ajouterEpreuve(nouvelleEpreuve);
        
        PanelEpreuve panel = new PanelEpreuve(_nomSport, cards, cardLayout, cards);
        cards.add(panel, "epreuveSport");
        cardLayout.show(cards, "epreuveSport");
        

	}
}
