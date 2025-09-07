package vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import modeles.Epreuve;
import modeles.Sport;

/**
 * @author Marc
 * @author Mathis
 */

public class VueEpreuveSport extends JPanel {
    
    private JPanel previousCardPanel;
    private CardLayout cardLayout;

    /**
     * 
     * @param sportName
     * @param cards
     * @param cardLayout
     * @param previousCardPanel
     */
    // Constructeur
    public VueEpreuveSport(String sportName, JPanel cards, CardLayout cardLayout, JPanel previousCardPanel) {
        
        this.previousCardPanel = previousCardPanel;
        this.cardLayout = cardLayout;

        JLabel label = new JLabel("Épreuves de " + sportName + " : ");
        JButton ajouterButton = new JButton("Ajouter");
        JPanel boutonPanel = new JPanel(new GridLayout(0, 1, 5, 5)); // Ajout de marges entre les boutons

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(label, BorderLayout.WEST);
        topPanel.add(ajouterButton, BorderLayout.EAST);

        // Récupérer les épreuves pour le sport spécifié
        Data donnee = new Data();
        Sport sport = donnee.chercherSport(sportName);
        
        ArrayList<Epreuve> epreuves = donnee.getEpreuveSport(sport);
        for (Epreuve epreuve : epreuves) {
            ajouterEpreuveBouton(boutonPanel, epreuve.getNomEpreuve());
        }

        setLayout(new BorderLayout());

        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        boutonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(boutonPanel), BorderLayout.CENTER); // Ajout du panel des boutons avec barre de défilement

        ajouterButton.addActionListener(e -> {
            PanelEpreuve panelEpreuve = new PanelEpreuve(sportName, cards, cardLayout, previousCardPanel);
            cards.add(panelEpreuve, "panelEpreuve");
            cardLayout.show(cards, "panelEpreuve");
        });

        JButton backButton = new JButton("Retour");
        backButton.addActionListener(e -> cardLayout.show(previousCardPanel, "vueEpreuve"));

        // bouton de retour
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * 
     * @param parentPanel
     * @param epreuveText
     */
    private void ajouterEpreuveBouton(JPanel parentPanel, String epreuveText) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JButton epreuveBouton = new JButton(epreuveText);
        JButton modifierBouton = new JButton("Modifier");
        JButton supprimerBouton = new JButton("Supprimer");
        
        supprimerBouton.addActionListener(e -> {
            // Supprimez l'épreuve associée du panneau des boutons
            parentPanel.remove(panel);
            parentPanel.revalidate();
            parentPanel.repaint();

            // Supprimez l'épreuve de la liste d'épreuves
            supprimerEpreuve(epreuveBouton);
        });

        // panel pour les boutons Modifier et Supprimer
        JPanel actionPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        actionPanel.add(modifierBouton);
        actionPanel.add(supprimerBouton);

        panel.add(epreuveBouton, BorderLayout.CENTER);
        panel.add(actionPanel, BorderLayout.EAST);

        parentPanel.add(panel);
    }

    /**
     * 
     * @param epreuveBouton
     */
    private void supprimerEpreuve(JButton epreuveBouton) {
		// TODO Auto-generated method stub
		
	}
}
