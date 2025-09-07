package vues;

import java.util.ArrayList;
import java.util.HashMap;

import modeles.*;

/**
 * @author William
 */

public class Data {

    // Déclaration des listes pour stocker les sports, athlètes, nations et épreuves existants
	private static ArrayList<Sport> sportExistant;
	private static ArrayList<Athlete> athleteExistant;
	private static ArrayList<Nation> nationExistante;
	private static ArrayList<Epreuve> epreuveExistante;
	
    // HashMap pour associer chaque sport à une liste d'épreuves
	public static ArrayList<Epreuve> getEpreuveExistante() {
		return epreuveExistante;
	}

	private static HashMap<Sport, ArrayList<Epreuve>> epreuveSport;

    // Constructeur de la classe Data
	public Data() {
        // Initialisation des listes de sports
		sportExistant = new ArrayList<Sport>();
		Sport s1 = new Sport("Athlétisme");
		Sport s2 = new Sport("Golf");
		Sport s3 = new Sport("Tir");
		Sport s4 = new Sport("Gymnastique");
		sportExistant.add(s1);
		sportExistant.add(s2);
		sportExistant.add(s3);
		sportExistant.add(s4);
		
        // Initialisation des athlètes
		Athlete a1 = new Athlete("Lionnel","Messi",19,"M");
		ArrayList<Athlete> athletes= new ArrayList<Athlete> ();
		athletes.add(a1);
		
        // Création et ajout des épreuves individuelles pour chaque sport
		EpreuveIndividuelle eiA1 = new EpreuveIndividuelle(s1, "100m", "Stade de France", 7, 12, 9, 12, athletes , 8, 1);
		EpreuveIndividuelle eiA2 = new EpreuveIndividuelle(s1, "Saut en Longueur",  "Stade de France", 7, 12, 9, 12, athletes , 15 , 5);
		EpreuveIndividuelle eiA3 = new EpreuveIndividuelle(s1, "Lancer de marteau",  "Stade de France", 7, 12, 9, 12, athletes , 8 , 1);
		EpreuveIndividuelle eiA4 = new EpreuveIndividuelle(s1, "Saut à la perche",  "Stade de France", 7, 12, 9, 12, athletes , 10 , 5);
		EpreuveIndividuelle eiA5 = new EpreuveIndividuelle(s1, "400m",  "Stade de France", 7, 12, 9, 12, athletes , 32 , 5);
		
		s1.ajouterEpreuve(eiA1);
		s1.ajouterEpreuve(eiA2);
		s1.ajouterEpreuve(eiA3);
		s1.ajouterEpreuve(eiA4);
		s1.ajouterEpreuve(eiA5);
		
		
		
		EpreuveIndividuelle eiG1 = new EpreuveIndividuelle(s2, "Stroke Play individuel 1er tour " , "Golf National", 7, 12, 9, 12, athletes, 10,5);
		EpreuveIndividuelle eiG2 = new EpreuveIndividuelle(s2, "Stroke Play individuel 1er tour ", "Golf National", 7, 12, 9, 12, athletes, 10,5);
		EpreuveIndividuelle eiG3 = new EpreuveIndividuelle(s2, "Stroke Play individuel 1er tour ", "Golf National", 7, 12, 9, 12, athletes, 10,5);

		s2.ajouterEpreuve(eiG1);
		s2.ajouterEpreuve(eiG2);
		s2.ajouterEpreuve(eiG3);
		
		EpreuveIndividuelle eiT1 = new EpreuveIndividuelle(s3, "Carabine à air comprimé 10m Finale", "Centre Nation de tir châteauroux", 7, 10, 9, 11, athletes, 10,5);
		EpreuveIndividuelle eiT2 = new EpreuveIndividuelle(s3, "Fosse olympique qualifications", "Stade de france", 7, 10, 9, 11, athletes, 10,1);
		EpreuveIndividuelle eiT3 = new EpreuveIndividuelle(s3, "50m rifle 3 positions,", "Stade de france", 7, 10, 9, 11, athletes, 10,0);
		EpreuveIndividuelle eiT4 = new EpreuveIndividuelle(s3, "25m pistolet feu rapide", "Stade de france", 7, 10, 9, 11, athletes, 10,5);

		s3.ajouterEpreuve(eiT1);
		s3.ajouterEpreuve(eiT2);
		s3.ajouterEpreuve(eiT3);
		s3.ajouterEpreuve(eiT4);
		
		
		EpreuveIndividuelle eiGy1 = new EpreuveIndividuelle(s4, "Arena Bercy", "Stade", 7, 05, 9, 12, athletes, 10,3);

		s4.ajouterEpreuve(eiGy1);
		
        // Initialisation de la HashMap associant chaque sport à ses épreuves
		epreuveSport = new HashMap<Sport, ArrayList<Epreuve>>();
		
		epreuveSport.put(s1, s1.get_sesEpreuves());
		epreuveSport.put(s2, s2.get_sesEpreuves());
		epreuveSport.put(s3, s3.get_sesEpreuves());
		epreuveSport.put(s4, s4.get_sesEpreuves());
		
	}
	
    /**
     * 
     * @param nom
     * @return
     */
    
    // Méthode pour chercher un sport par son nom
	public Sport chercherSport(String nom) {
		Sport res = null;
		for(Sport s : sportExistant) {
			if (s.get_nomSport().equals(nom)) {
				res = s;
			}
		}
		
		return res;
	}
	
    /**
     * 
     * @param nom
     * @return
     */
    // Méthode pour vérifier si un sport existe par son nom
	public boolean sportExiste(String nom) {
		boolean res = false;
		for(Sport s : sportExistant) {
			if (s.get_nomSport().equals(nom)) {
				res = true;
			}
		}
		return res;
	}

	
    // Méthodes d'accès pour obtenir les listes existantes
	public static ArrayList<Sport> getSportExistant() {
		return sportExistant;
	}


	public static ArrayList<Athlete> getAthleteExistant() {
		return athleteExistant;
	}


	public static ArrayList<Nation> getNationExistante() {
		return nationExistante;
	}
	
    // Méthode pour obtenir les épreuves d'un sport donné
	public static ArrayList<Epreuve> getEpreuveSport(Sport sport) {
		return epreuveSport.get(sport);
	}
	


}
