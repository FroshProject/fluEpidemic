package src.Element;
/**
 * Homme est la classe contenant les méthodes spécifiques au Homme. Cette classe hérite de la classe 'Etre'
 * 
 * @see Etre
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Homme extends Etre {

	/**
	 * Constructeur par defaut, utilise le constructeur de la classe Etre
	 * 
	 * @see Etre
	 */
	public Homme() {
		super();
	}

	/**
     * Surcharge de la méthode getType() de la classe Etre.
	 *
	 * @see Etre
	 *
     */
	@Override
	public String getType() {
		return "H";
	}

	/**
	 * Surcharge de la méthode toString() de la classe Etre.
	 *
	 * @see Etre
	 *
	 */
	@Override
	public String toString() {
	    String result = "H" + this.numEtat();
		return result;
	}
}
