package controleurs;

import vues.PanelAjouterSession;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modeles.Session;

/**
 * @author Marc
 */

public class ControllerSession {

    private PanelAjouterSession vue;

    public ControllerSession(PanelAjouterSession vue) {
        this.vue = vue;

        // Ajout des écouteurs d'événements pour les boutons ">>" et "<<"
        vue.addButton.addActionListener(new AjouterEpreuveListener());
        vue.removeButton.addActionListener(new SupprimerEpreuveListener());

    }

    

    public void actionPerformed(ActionEvent e) {
        // Récupérer les informations des champs de texte
        String dateSession = vue.dateSessionField.getText();
        String heureDebut = vue.heureDebutField.getText();
        String minuteDebut = vue.minuteDebutField.getText();
        String heureFin = vue.heureFinField.getText();
        String minuteFin = vue.minuteFinField.getText();

        // Créer une nouvelle session avec les informations récupérées
        Session nouvelleSession = new Session(dateSession, heureDebut, minuteDebut, heureFin, minuteFin);

        // Ajouter la nouvelle session à votre modèle de données si nécessaire
        // Exemple : votreModèle.ajouterSession(nouvelleSession);

        // Afficher un message de confirmation
        JOptionPane.showMessageDialog(null, "Session ajoutée avec succès !");
    }


    // Listener pour le bouton ">>"
    class AjouterEpreuveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Récupérer l'épreuve sélectionnée dans la liste source
            String epreuveSelectionnee = vue.sourceList.getSelectedValue();
            if (epreuveSelectionnee != null) {
                // Ajouter l'épreuve à la liste destination
                vue.destListModel.addElement(epreuveSelectionnee);
            }
        }
    }

    // Listener pour le bouton "<<"
    class SupprimerEpreuveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Récupérer l'épreuve sélectionnée dans la liste destination
            int index = vue.destList.getSelectedIndex();
            if (index != -1) {
                // Supprimer l'épreuve de la liste destination
                vue.destListModel.remove(index);
            }
        }
    }
    
}

   
