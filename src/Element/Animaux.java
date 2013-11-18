package src.Element;

import src.Etat.*;

/**
 * Animaux est la classe contenant les methodes specifiques aux animaux. Cette classe herite de la classe 'Etre'
 *
 * @author Roumegue Jeremy
 * @version 1.0.0
 */

import java.util.Random;

public class Animaux extends Etre {
	/**
     * Creer une nouvelle instance d'un nombre aleatoire.
     *
     * @see Random
     */
	public Random rd = new Random();

	/**
     * Creer un nouvel animal avec une chance de 0,5 d'etre malade.
     */
	public Animaux () {
		int rdnum = rd.nextInt(2); // Creer un nombre aleatoire
		if(rdnum == 0) { // Si le nombre est 0, on rend l'animal malade.
		    this.setState(Etat.Sick);
		} else { // Sinon l'animal est creer en bonne sante.
		    this.setState(Etat.Healthy);
		}
	}
}
