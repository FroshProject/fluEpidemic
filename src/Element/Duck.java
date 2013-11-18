package src.Element;

import src.Maladie.*;

/**
 * Duck est la classe contenant les méthodes spécifiques au Duck. Cette classe hérite de la classe 'Etre' et 'Animaux'
 * 
 * @see Etre
 *
 * @see Animaux
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Duck extends Animaux {

	/**
     * Créer un nouveau Duck.
     */
	public Duck () {
		super();
		if (this.isSick()){
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
		return "D";
	}

	/**
	 * Surcharge de la méthode toString() de la classe Etre.
	 *
	 * @see Etre
	 *
	 */
	@Override
	public String toString() {
	    String result = "D" + this.numEtat();
		return result;
	}
}
