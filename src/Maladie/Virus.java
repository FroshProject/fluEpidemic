package src.Maladie;


/**
 * 
 * Virus est la classe mere des deux types de Virus.
 *
 * @author Roumegue Jeremy
 * @version 1.0.0
 * 
 */
public class Virus {
    protected String numVirus;
	protected int incubation;

	/**
	 * Constructeur par defaut d'un Virus
	 */
    public Virus () {
        this.numVirus = "0";
		this.incubation = 0;
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
	
	@Override
	  public boolean equals(Object o){
		  Virus tmp = (Virus)o;
		  return (this.incubation == tmp.incubation)&&(this.numVirus.equals(tmp.numVirus));
	  }
}
