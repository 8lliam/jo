package vues;

import modeles.*;

import javax.swing.*;

import controleurs.ControllerSession;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author Marc
 * @author William
 */

public class PanelAjouterSession extends JPanel {

    private Session modele;

    public JTextField heureDebutField;
    public JTextField minuteDebutField;
    public JTextField heureFinField;
    public JTextField minuteFinField;
    public JList<String> sourceList; // liste des épreuves disponibles
    public JList<String> destList;
    public DefaultListModel<String> sourceListModel; // modèles pour les listes
    public DefaultListModel<String> destListModel;
    public JButton addButton;
    public JButton removeButton;
    public JButton ajouterButton;
    public JLabel titleLabel;
    
    public JTextField dateSessionField;

    public PanelAjouterSession() {

        heureDebutField = new JTextField(2);
        minuteDebutField = new JTextField(2);
        heureFinField = new JTextField(2);
        minuteFinField = new JTextField(2);
        dateSessionField = new JTextField(10); // taille du texte pour la date

        heureDebutField.setText("");
        minuteDebutField.setText("");
        heureFinField.setText("");
        minuteFinField.setText("");

        sourceListModel = new DefaultListModel<>();
        destListModel = new DefaultListModel<>();
        sourceList = new JList<>(sourceListModel);
        destList = new JList<>(destListModel);
        addButton = new JButton(">>");
        removeButton = new JButton("<<");
        ajouterButton = new JButton("Ajouter");
        titleLabel = new JLabel("Gestion des Sessions", JLabel.CENTER); // titre

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // ajuster la taille et le style de la police du titre
        add(titleLabel, gbc);

        // Ajout du label et du champ de texte pour la date de la session
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Date de la session (jour/mois/année):"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(dateSessionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Heure de début de la session (HH/MM):"), gbc);

        JPanel startTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        startTimePanel.add(heureDebutField);
        startTimePanel.add(new JLabel("h"));
        startTimePanel.add(minuteDebutField);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(startTimePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Heure de fin de la session (HH/MM):"), gbc);

        JPanel endTimePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        endTimePanel.add(heureFinField);
        endTimePanel.add(new JLabel("h"));
        endTimePanel.add(minuteFinField);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(endTimePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(createDualListBoxWithLabels(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(ajouterButton, gbc);
        
        
    }

    private JPanel createDualListBoxWithLabels() {
        JPanel dualListBoxPanel = new JPanel(new GridBagLayout()); // permet de faire une instance de contrainte
        GridBagConstraints gbc = new GridBagConstraints(); // pour spécifier les contraintes de disposition des composants
        gbc.insets = new Insets(5, 5, 5, 5);

        // on met les labels au-dessus des ListBox pour dire laquelle c'est
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dualListBoxPanel.add(new JLabel("Epreuves libres"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        dualListBoxPanel.add(new JLabel("Epreuves sélectionnées"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        dualListBoxPanel.add(new JScrollPane(sourceList), gbc); // JScrollPane permet de faire défiler dans la liste

        // on ajoute les boutons pour ajouter et enlever les épreuves sélectionnées entre les deux ListBox
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.NONE;
        dualListBoxPanel.add(buttonsPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        gbc.fill = GridBagConstraints.BOTH;
        dualListBoxPanel.add(new JScrollPane(destList), gbc);

        return dualListBoxPanel;
    }

    /**
     * 
     * @param modele
     */
    // Méthode pour définir le modèle de la session
    public void updateSourceListFromModele() {
        String[] epreuves = modele.getNomsEpreuvesProposees();
        updateSourceList(epreuves);
    }

    /**
     * 
     * @param epreuves
     */
    // Méthode pour mettre à jour la liste des épreuves disponibles
    public void setModele(Session modele) {
        this.modele = modele;
    }

    // Méthode pour mettre à jour la liste des épreuves disponibles
    public void updateSourceList(String[] epreuves) {
        sourceListModel.clear();
        for (String epreuve : epreuves) {
            sourceListModel.addElement(epreuve);
        }
    }
}
