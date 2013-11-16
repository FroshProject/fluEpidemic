package Etat;
/**
 * Recovering est une classe d'Etat faisant parti du Pattern d'Etat.
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public class Recovering implements Etat {

	/**
	 * Variable correspondant à la duree de l'Etat.
	 */
	public int tpsEtat = 4;
	
	/**
	 * Methode retournant la duree de l'etat Recovering.
	 *
	 * @return La duree de l'etat Recovering.
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
		return false;
	}

	/**
	 * Methode surchargee retournant la representation de l'etat Recovering.
	 *
	 * @return Un String permettant de reconaitre l'etat.
	 *
	 * @see Etat
	 */
	@Override
	public String numEtat() {
		return "3";
	}
	@Override
	  public boolean equals(Object o){
		  Etat tmp = (Etat)o;
		  return (this.numEtat().equals(tmp.numEtat()))&&(this.getTpsEtat() == tmp.getTpsEtat());
	  }
}
