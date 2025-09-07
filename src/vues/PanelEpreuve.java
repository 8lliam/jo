package vues;

import javax.swing.*;

import controleurs.EcouteurGererEpreuve;
import modeles.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Marc
 * @author William
 */


public class PanelEpreuve extends JPanel implements Phase{
	
	// declaration des des champs de texte


	public JTextField tfNomEpreuve;
	public JTextField tfJourDebut;
	public JTextField tfMoisDebut;
	public JTextField tfJourFin;
	public JTextField tfMoisFin;
	public JTextField tfLieuEpreuve;
	public JTextField tfNbParticipantsMax;
	public JButton bCreerEpreuve;
	public JComboBox<String> comboBoxGenre;
	public JComboBox<String> comboBoxStatut;
	private CardLayout cardLayout;
	private JPanel previousCardPanel;
	

	/**
	 * 
	 * @param sport
	 */
	// Constructeur panel epreuve
	public PanelEpreuve(String sportName, JPanel cards, CardLayout cardLayout, JPanel previousCardPanel){
		
		this.previousCardPanel = previousCardPanel;
        this.cardLayout = cardLayout;
        
		tfNomEpreuve = new JTextField();
		tfNomEpreuve.setPreferredSize(new Dimension(150, 25));

		tfLieuEpreuve = new JTextField();
		tfLieuEpreuve.setPreferredSize(new Dimension(150, 25));

		tfJourDebut = new JTextField();
		tfJourDebut.setPreferredSize(new Dimension(100, 40));

		tfMoisDebut = new JTextField();
		tfMoisDebut.setPreferredSize(new Dimension(100, 40));

		tfJourFin = new JTextField();
		tfJourFin.setPreferredSize(new Dimension(100, 40));

		tfMoisFin = new JTextField();
		tfMoisFin.setPreferredSize(new Dimension(100, 40));

		tfNbParticipantsMax = new JTextField();
		tfNbParticipantsMax.setPreferredSize(new Dimension(150, 25));

		String[] genres = {"Homme", "Femme", "Mixte"};
		comboBoxGenre = new JComboBox<>(genres);
		comboBoxGenre.setPreferredSize(new Dimension(150, 25));


		comboBoxStatut = new JComboBox<>(phaseTab);
		comboBoxStatut.setPreferredSize(new Dimension(150, 25));

		bCreerEpreuve = new JButton("Créer épreuve");
		bCreerEpreuve.setPreferredSize(new Dimension(150, 40));



		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		// Title
		JLabel title = new JLabel("Création d'épreuve", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 24));
		add(title, BorderLayout.NORTH);

		JPanel panelSaisie = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 20, 20);

		// Nom épreuve
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.25;
		gbc.weighty = 0.5;
		JLabel labelNomEpreuve = new JLabel("Nom épreuve:");
		labelNomEpreuve.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelNomEpreuve, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		panelSaisie.add(tfNomEpreuve, gbc);

		// Lieu
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.25;
		JLabel labelLieu = new JLabel("Lieu de l'épreuve:");
		labelLieu.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelLieu, gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 0.5;
		panelSaisie.add(tfLieuEpreuve, gbc);

		// Date début
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		JLabel labelDateDebut = new JLabel("Date de début:");
		labelDateDebut.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelDateDebut, gbc);

		JPanel startDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		startDatePanel.add(tfJourDebut);
		JLabel slashDebut = new JLabel("/");
		slashDebut.setFont(new Font("Arial", Font.PLAIN, 20));
		startDatePanel.add(slashDebut);
		startDatePanel.add(tfMoisDebut);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		panelSaisie.add(startDatePanel, gbc);

		// Date fin
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 0.1;
		JLabel labelDateFin = new JLabel("Date de fin:");
		labelDateFin.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelDateFin, gbc);

		JPanel endDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
		endDatePanel.add(tfJourFin);
		JLabel slashFin = new JLabel("/");
		slashFin.setFont(new Font("Arial", Font.PLAIN, 20));
		endDatePanel.add(slashFin);
		endDatePanel.add(tfMoisFin);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.weightx = 0.2;
		panelSaisie.add(endDatePanel, gbc);

		// Nombre de personnes maximum
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.25;
		JLabel labelNbParticipantsMax = new JLabel("Nombre de personnes max:");
		labelNbParticipantsMax.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelNbParticipantsMax, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 0.5;
		panelSaisie.add(tfNbParticipantsMax, gbc);

		// Genre
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.weightx = 0.25;
		JLabel labelGenre = new JLabel("Genre épreuve:");
		labelGenre.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelGenre, gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.weightx = 0.5;
		panelSaisie.add(comboBoxGenre, gbc);

		// Statut épreuve
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.25;
		JLabel labelStatutEpreuve = new JLabel("Statut de l'épreuve:");
		labelStatutEpreuve.setFont(new Font("Arial", Font.PLAIN, 16));
		panelSaisie.add(labelStatutEpreuve, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 0.5;
		panelSaisie.add(comboBoxStatut, gbc);

		// Bouton pour créer l'épreuve
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.weighty = 2;
		panelSaisie.add(bCreerEpreuve, gbc);

		add(panelSaisie, BorderLayout.CENTER);
		
		Data donnee = new Data();
		Sport sport = donnee.chercherSport(sportName);

		EcouteurGererEpreuve ecouteur = new EcouteurGererEpreuve(sportName, tfNomEpreuve, tfJourDebut, tfMoisDebut, tfJourFin, tfMoisFin, tfLieuEpreuve, tfNbParticipantsMax, comboBoxGenre, 
				comboBoxStatut, previousCardPanel, cardLayout );
		
		bCreerEpreuve.addActionListener(ecouteur);
		
		
	}

}

