package vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import modeles.*;
import controleurs.EcouteurEpreuve;

/**
 * @author Mathis
 * @author Marc
 */

public class Discipline extends JPanel {

    private ArrayList<Sport> _sports;
    private JPanel _previousCardPanel;
    private CardLayout _cardLayout;

    
    /**
     * 
     * @param previousCardPanel
     * @param cards
     * @param cardLayout
     */
    // Constructeur de la classe Discipline
    public Discipline(JPanel previousCardPanel, JPanel cards, CardLayout cardLayout) {
        this._previousCardPanel = previousCardPanel;
        this._cardLayout = cardLayout;

        // Création d'un label pour le titre "Sports : "
        JLabel lSportnom = new JLabel("Sports : ");
        JPanel boutonPanel = new JPanel(new GridLayout(0, 1, 5, 5)); // Ajout de marges entre les boutons

        // Panel pour le label
        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(lSportnom, BorderLayout.WEST);

        // Récupération des sports existants
        Data data = new Data();
        _sports = data.getSportExistant();

        // Boucle pour ajouter des boutons pour chaque sport
        for (Sport sport : _sports) {
            ajouterSportBouton(boutonPanel, sport.get_nomSport(), cards, cardLayout);
        }

        setLayout(new BorderLayout());

        // Marges autour du titre et des boutons
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Margin du titre de la page
        boutonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Margin entre chaque bouton sport

        // Ajout des panels au layout principal
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(boutonPanel), BorderLayout.CENTER); // Ajout du panel des boutons avec barre de défilement
        
        // Création du bouton de retour
        JButton backButton = new JButton("Retour");
        backButton.addActionListener(e -> cardLayout.show(previousCardPanel, "accueil")); // Remplacez "accueil" par le nom de la carte précédente

        // Panel pour le bouton de retour
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * 
     * @param parentPanel
     * @param sportText
     * @param cards
     * @param cardLayout
     */
    // Méthode pour ajouter des boutons de sport au panel parent
    private void ajouterSportBouton(JPanel parentPanel, String sportText, JPanel cards, CardLayout cardLayout) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JButton sportBouton = new JButton(sportText);

        // Ajout d'un action listener au bouton de sport
        sportBouton.addActionListener(new EcouteurEpreuve(cards, sportText, cardLayout, this));

        panel.add(sportBouton, BorderLayout.CENTER);

        // Ajout du panel au panneau parent
        parentPanel.add(panel);
    }
}