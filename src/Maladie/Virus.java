package src.Maladie;


/**
 * 
 * Virus est un enum contenant les Virus de base.
 *
 * @author Roumegue Jeremy
 * @version 1.0.0
 * 
 */

public enum Virus {
	  //Virus de base.
	  H1N1("2", 3),
	  H5N1("1", 4), 
	  None("O", 0);
	  
	  
	  private String numVirus;
	  private int incubation;
	   
	  //Constructeur
	  Virus (String numVirus, int incubation) {
	        this.numVirus = numVirus;
			this.incubation = incubation;
	    }
	  
	    /**
	     * 
	     * Methode permettant de connaitre combien de temps faut t'il avant d'etre contagieux.
	     * 
	     * @return Le temps d'incubation du Virus.
	     */
	  public int getIncubation() {
			return this.incubation;
		}

	}