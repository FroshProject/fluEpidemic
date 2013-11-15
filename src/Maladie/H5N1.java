package Maladie;
/**
 * H5N1 est la classe contenant les méthodes spécifiques au Virus H5N1. Cette classe hérite de la classe 'Virus'
 *
 * @see Virus
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class H5N1 extends Virus {
	
	/**
	 * Constructeur principal et par defaut.
	 */
    public H5N1 () {
        this.numVirus = "1";
	this.incubation = 4;
    }
}
