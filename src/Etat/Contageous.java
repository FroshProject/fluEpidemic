package Etat;
/**
 * Contageous est une classe d'Etat faisant parti du Pattern d'Etat. Elle rend un Etre capable de contaminer d'autre Etre.
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Contageous implements Etat {

	/**
	 * Variable correspondant à la duree de l'Etat.
	 */
	public int tpsEtat = 3;

	/**
	 * Methode retournant la duree de l'etat Contageous.
	 *
	 * @return La duree de l'etat Contageous.
	 */
	public int getTpsEtat() {
		return tpsEtat;
	}

	/**
	 * Methode surchargee retournant un booleen si l'etat est contagieux.
	 *
	 * @return Un booleen permettant de savoir si l'etat est contagieux ou pas.
	 * @see Etat
	 * 
	 */
	@Override
	public boolean setContagieux() {
		return true;
	}

	/**
	 * Methode surchargee retournant la representation de l'etat Contageous.
	 *
	 * @return Un String permettant de reconaitre l'etat.
	 *
	 * @see Etat
	 */
	@Override
	public String numEtat() {
		return "2";
	}

}
