package Etat;
/**
 * Healthy est une classe d'Etat faisant parti du Pattern d'Etat.
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Healthy implements Etat {
	
	/**
	 * Methode retournant la duree de l'etat Healthy.
	 *
	 * @return La duree de l'etat Healthy (0).
	 */
	public int getTpsEtat() {
		return tpsEtat;
	}

	/**
	 * Methode surchargee retournant une boolean si l'etat est contagieux.
	 *
	 * @return Un booleen permettant de savoir si l'etat est contagieux ou pas.
	 * @see Etat
	 */
	@Override
	public boolean setContagieux() {
		return false;
	}

	/**
	 * Methode surchargee retournant la representation de l'etat Healthy.
	 *
	 * @return Un String permettant de reconaitre l'etat.
	 *
	 * @see Etat
	 */
	@Override
	public String numEtat() {
		return "0";
	}
}