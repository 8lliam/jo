package controleurs;

import vues.VueEpreuveSport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Mathis
 */

public class EcouteurEpreuve implements ActionListener {

    private JPanel cards;// Le conteneur principal avec CardLayout
    private String sport;// Le nom du sport sélectionné
    private CardLayout cardLayout;// Le gestionnaire de disposition CardLayout
    JPanel panelPrecedent;// Le panneau précédent à afficher lorsque nécessaire

    /**
     * 
     * @param cards
     * @param sport
     * @param cardLayout
     * @param panelPrecedent
     */
    // Constructeur
    public EcouteurEpreuve(JPanel cards, String sport, CardLayout cardLayout, JPanel panelPrecedent) {
        this.cards = cards;
        this.sport = sport;
        this.cardLayout = cardLayout;
        this.panelPrecedent = panelPrecedent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Remplacer la vue actuelle par VueEpreuveSport
        VueEpreuveSport vueEpreuveSport = new VueEpreuveSport(sport, cards, cardLayout, panelPrecedent);
        cards.add(vueEpreuveSport, "epreuveSport");
        cardLayout.show(cards, "epreuveSport");
    }
}