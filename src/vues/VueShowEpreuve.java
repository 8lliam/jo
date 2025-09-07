package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

import modeles.*;
import controleurs.*;

/**
 * @author Dane
 */

public class VueShowEpreuve extends JPanel {

    JLabel LdateEpreuve;
    JLabel LlieuEpreuve;
    JLabel titreEpreuve;

    /**
     * 
     * @param epreuve
     */
    // constructeur
    public VueShowEpreuve(Epreuve epreuve) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        titreEpreuve = new JLabel(epreuve.getNomEpreuve(), JLabel.CENTER);
        titreEpreuve.setFont(titreEpreuve.getFont().deriveFont(24.0f)); // Augmenter la taille de la police

        // Initialiser les JLabel avec les informations de l'épreuve
        LdateEpreuve = new JLabel("Date de l'épreuve : " + epreuve.getDateDebut() + " - " + epreuve.getDateFin());
        LlieuEpreuve = new JLabel("Lieu de l'épreuve : " + epreuve.getLieuEpreuve());

        // Panneau pour les détails de l'épreuve
        JPanel panelEpreuve = new JPanel(new GridLayout(4, 2));
        panelEpreuve.add(titreEpreuve);
        panelEpreuve.add(LdateEpreuve);
        panelEpreuve.add(LlieuEpreuve);

        // Ajouter les composants au JPanel principal
        add(titreEpreuve, BorderLayout.NORTH);
        add(panelEpreuve, BorderLayout.CENTER);
    }
}
