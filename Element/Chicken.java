package Element;

import Maladie.*;

/**
 * Chicken est la classe contenant les méthodes spécifiques au Chicken. Cette classe hérite de la classe 'Etre' et 'Animaux'
 * 
 * @see Etre
 *
 * @see Animaux
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */

public class Chicken extends Animaux {

	/**
     * Créer un nouveau Chicken.
     */
	public Chicken () {
		super();
		if (this.getState().numEtat() == "1"){
            		this.setVirus(new H5N1());
		}
		immune = new H5N1();
	}

	/**
     * Surcharge de la méthode getType() de la classe Etre.
	 *
	 * @see Etre
	 *
     */
	@Override
	public String getType() {
		return "C";
	}

	/**
	 * Surcharge de la méthode toString() de la classe Etre.
	 *
	 * @see Etre
	 *
	 */
	@Override
	public String toString() {
	    String result = "C" + this.numEtat();
		return result;
	}
}
