package Etat;
/**
 * Etat est une interface creant le pattern Etat.
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public interface Etat {
	
	/**
	 * Variable correspondant à la duree de l'Etat. 0 est la duree par defaut (infini).
	 *
	 */
	public int tpsEtat = 0;
	
	/**
	 * Methode permettant de savoir si l'etat est contagieux.
	 *
	 * @return Un booleen permettant de savoir si l'etat est contagieux ou pas.
	 * 
	 */
	public boolean setContagieux();

	/**
	 * Methode donnant la representation de l'etat Contageous.
	 *
	 * @return Un String permettant de reconaitre l'etat.
	 *
	 */
	public String numEtat();

	/**
	 * Methode permettant de connaitre la duree de l'etat.
	 *
	 * @return La duree de l'etat.
	 */
	public int getTpsEtat();
}
