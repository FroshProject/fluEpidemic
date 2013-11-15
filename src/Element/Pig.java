package Element;

import Maladie.*;

/**
 * Pig est la classe contenant les méthodes spécifiques au Pig. Cette classe hérite de la classe 'Etre' et 'Animaux'
 * 
 * @see Etre
 *
 * @see Animaux
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Pig extends Animaux {

	/**
     * Créer un nouveau Pig.
     */
	public Pig () {
        	super();
		if (this.getState().numEtat() == "1"){
            		this.setVirus(new H5N1());
		}
		immune = new H1N1();
	}

	/**
     * Surcharge de la méthode getType() de la classe Etre.
	 *
	 * @see Etre
	 *
     */
	@Override
	public String getType() {
		return "P";
	}

	/**
	 * Surcharge de la méthode toString() de la classe Etre.
	 *
	 * @see Etre
	 *
	 */
	@Override
	public String toString() {
	    String result = "P" + this.numEtat();
		return result;
	}
}
