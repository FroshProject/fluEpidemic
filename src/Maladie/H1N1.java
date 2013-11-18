package src.Maladie;
/**
 * H1N1 est la classe contenant les méthodes spécifiques au Virus H1N1. Cette classe hérite de la classe 'Virus'
 *
 * @see Virus
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 * 
 * 
 * 
 */
public class H1N1 extends Virus {
	
	/**
	 * Constructeur principal et par defaut.
	 */
    public H1N1 () {
        this.numVirus = "2";
	this.incubation = 3;
    }
}
