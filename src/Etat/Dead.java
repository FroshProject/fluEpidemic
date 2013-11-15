package Etat;
/**
 * Dead est une classe d'Etat faisant parti du Pattern d'Etat. Elle met un Etre a l'etat de Mort.
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Dead implements Etat {

	/**
	 * Methode retournant la duree de l'etat Dead.
	 *
	 * @return La duree de l'etat Dead (0).
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
	 * Methode surchargee retournant la representation de l'etat Dead.
	 *
	 * @return Un String permettant de reconaitre l'etat.
	 *
	 * @see Etat
	 */
	@Override
	public String numEtat() {
		return "☠";
	}
}
