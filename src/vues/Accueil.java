package vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import modeles.*;
import controleurs.*;
import java.util.HashMap;

/**
 * @author Mathis
 * @author William
 */

public class Accueil extends JFrame {
	
	/**
	 * 
	 * 
	 */
    // Panneaux pour les différentes cartes et la disposition en CardLayout
    private JPanel _cards;
    private CardLayout _cardLayout;

    // Vue pour la discipline
    private Discipline _vueDiscipline;

    // Boutons de navigation
    private JButton _accueilButton;
    private JButton _disciplineButton;
    private JButton _equipeButton;
    private JButton _sessionButton;
    private JButton _planningButton;

    /**
     * 
     * @param iconDirectory
     */
    /**
     * 
     * @param iconDirectory
     */
    // Constructeur
    public Accueil(String iconDirectory) {
        super("ApplicationJO");
        setLayout(new BorderLayout());

        // Initialisation du CardLayout et du panneau de cartes
        _cardLayout = new CardLayout();
        _cards = new JPanel(_cardLayout);

        /**
         * 
         */
        // Création du panneau d'accueil
        JPanel homePanel = new JPanel();
        homePanel.setBackground(Color.WHITE);
        JLabel welcomeLabel = new JLabel("Bienvenue sur l'application JO!");
        homePanel.add(welcomeLabel);
        _cards.add(homePanel, "accueil");
        
        // Vue pour la discipline
        _vueDiscipline = new Discipline(_cards, _cards, _cardLayout); // Passez cards comme carte précédente
        _cards.add(_vueDiscipline, "vueDiscipline");
        
        // Création des panneaux pour les autres fonctionnalités
        PanelEquipe equipePanel = new PanelEquipe();
        _cards.add(equipePanel, "equipe");
        
        PanelSession sessionPanel = new PanelSession();
        _cards.add(sessionPanel, "session");

        PanelPlanning planningPanel = new PanelPlanning();
        _cards.add(planningPanel, "planning");

        // Ajout des cartes au panneau principal
        add(_cards, BorderLayout.CENTER);

        // Création des boutons de navigation
        _accueilButton = createNavigationButton("Accueil", null);
        _disciplineButton = createNavigationButton("Discipline", new ImageIcon(iconDirectory + "images/equ.png"));
        _equipeButton = createNavigationButton("Equipe", new ImageIcon(iconDirectory + "images/sess.png"));
        _sessionButton = createNavigationButton("Session", new ImageIcon(iconDirectory + "images/epr.png"));
        _planningButton = createNavigationButton("Planning", new ImageIcon(iconDirectory + "images/cal.png"));

        // Ajout des actions pour les boutons de navigation
        _accueilButton.addActionListener(e -> _cardLayout.show(_cards, "accueil"));
        _disciplineButton.addActionListener(e -> _cardLayout.show(_cards, "vueDiscipline"));
        _equipeButton.addActionListener(e -> _cardLayout.show(_cards, "equipe"));
        _sessionButton.addActionListener(e -> _cardLayout.show(_cards, "session"));
        _planningButton.addActionListener(e -> _cardLayout.show(_cards, "planning"));

        // Création du panneau de navigation à gauche
        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new GridLayout(5, 0));
        
        // Ajout des boutons de navigation au panneau
        navigationPanel.add(_accueilButton);
        navigationPanel.add(_disciplineButton);
        navigationPanel.add(_equipeButton);
        navigationPanel.add(_sessionButton);
        navigationPanel.add(_planningButton);
        add(navigationPanel, BorderLayout.WEST);
    }

    /**
     * 
     * @param text
     * @param icon
     * @return
     */
    // Méthode pour créer un bouton de navigation
    private JButton createNavigationButton(String text, ImageIcon icon) {
        JButton button = new JButton(text, icon);
        button.setContentAreaFilled(false);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        return button;
    }

    // Méthode pour ajuster la taille des boutons en fonction de la taille de la fenêtre
    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);

        int buttonHeight = height / 5;
        int buttonWidth = width / 5;
        Dimension buttonSize = new Dimension(buttonWidth, buttonHeight);

        _accueilButton.setPreferredSize(buttonSize);
        _accueilButton.setMaximumSize(buttonSize);
        _accueilButton.setMinimumSize(buttonSize);

        _disciplineButton.setPreferredSize(buttonSize);
        _disciplineButton.setMaximumSize(buttonSize);
        _disciplineButton.setMinimumSize(buttonSize);

        _equipeButton.setPreferredSize(buttonSize);
        _equipeButton.setMaximumSize(buttonSize);
        _equipeButton.setMinimumSize(buttonSize);

        _sessionButton.setPreferredSize(buttonSize);
        _sessionButton.setMaximumSize(buttonSize);
        _sessionButton.setMinimumSize(buttonSize);

        _planningButton.setPreferredSize(buttonSize);
        _planningButton.setMaximumSize(buttonSize);
        _planningButton.setMinimumSize(buttonSize);
    }
    
    /**
     * 
     * @param args
     */
    // Méthode principale pour lancer l'application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Accueil app = new Accueil("images/");
            app.setSize(1000, 675);
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setVisible(true);
        });
    }
}

//Classe pour le panneau d'équipe
class PanelEquipe extends JPanel {
    public PanelEquipe() {
        setBackground(Color.LIGHT_GRAY);
        add(new JLabel("Panneau Équipe"));
    }
}

//Classe pour le panneau de session
class PanelSession extends JPanel {
    public PanelSession() {
        setBackground(Color.CYAN);
        add(new JLabel("Panneau Session"));
    }
}

//Classe pour le panneau de planning
class PanelPlanning extends JPanel {
    public PanelPlanning() {
        setBackground(Color.PINK);
        add(new JLabel("Panneau Planning"));
    }
}