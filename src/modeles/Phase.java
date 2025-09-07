package modeles;

/**
 * @author William
 */

public interface Phase {
	public int FINALE = 0; //ou médaille
	int DEMI_FINALE = 1;
	int QUART_FINALE = 2;
	int HUITIEME_FINALE = 3;
	int POULE = 4;
	int QUALIFICATION = 5;
	int TROISIEME_PLACE = 6; //la petite finale en gros
    String [] phaseTab = {"Finale","Demi-finale","Quart de finale","Huitième de finale","Poule","Qualification","Troisième place"};
}
