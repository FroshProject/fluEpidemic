package src.Element;

import src.Maladie.*;
import src.Etat.*;

/**
 * La class Etre est la classe mere des classes Homme, Pig, Duck et Chicken. Elle contient toutes les methodes pour modifier ou construire un Etre.
 * 
 * @author Roumegue Jeremy
 * @version 1.0.0
 * 
 */
public class Etre {

	/**
	 * Variable permettant d'avoir un Etat pour chaque Etre.
	 */
	private Etat state;
	
	/**
	 * Variable permettant d'avoir un Virus pour chaque Etre.
	 */
	private Virus virus;
	
	/**
	 * Variable permettant de connaitre le temps passe dans un Etat.
	 */
	private int stateDay = 1;
	
	/**
	 * Variable permettant de connaitre les immunites d'un Etre.
	 */
	protected Virus immune;

	/**
	 * Constructeur par defaut.
	 */
	public Etre () {
	    this.state = Etat.Healthy;
		this.virus = Virus.None;
		this.immune = null;
	}

	/**
	 * Methode permettant de mettre un Etat a un Etre
	 * 
	 * @param etat L'Etat a mettre en place sur l'Etre.
	 */
	public void setState (Etat etat) {
		this.state = etat;
	}

	/**
	 * Methode permettant de savoir dans quel Etat est l'Etre.
	 * 
	 * @return L'Etat de l'Etre.
	 */
	public Etat getState () {
		return this.state;
	}

	/**
	 * Methode permettant de savoir le nombre de jour passe dans l'Etat actuel
	 * 
	 * @return Le nombre de jour passer dans l'Etat actuel (en integer).
	 */
	public int getStateDay(){
        return this.stateDay;
	}

	/**
	 * Remet a zero le temps passe dans un Etat. Effectue suite a un changement d'Etat.
	 */
	public void resetStateDay(){
        this.stateDay = 1;
	}

	/**
	 * Incremente le nombre de jour passe dans l'Etat actuel de 1.
	 */
	public void incStateDay() {
    	this.stateDay++;
	}

	/**
	 * Permet de savoir si un Etre est contagieux.
	 * 
	 * @return Un booleen. Vrai si l'Etre est contagieux, faux sinon.
	 */
	public boolean setContagieux() {
		return state.setContagieux();
	}

	/**
	 * Permet de savoir le numero de l'Etat.
	 * 
	 * @return Renvoie le numero de l'Etat en String.
	 */
	public String numEtat() {
		return state.numEtat();
	}

	/**
	 * Methode renvoyant le Virus de l'Etre.
	 * 
	 * @return Le virus attrapper par l'Etre.
	 */
	public Virus getVirus () {
		return this.virus;
	}

	/**
	 * Methode permettant de donner un virus a un Etre.
	 * 
	 * @param v1 Le virus a implanter chez l'Etre.
	 */
	public void setVirus (Virus v1) {
		this.virus = v1;
	}

	/**
	 * Methode permettant de connaitre les immunites de l'Etre.
	 * 
	 * @return Le virus dans lequel l'Etre est immunise.
	 */
	public Virus getImmune() {
		return this.immune;
	}

	/**
	 * Methode permettant de savoir si l'Etre est Healthy.
	 * 
	 * @return un booleen. Vrai si l'Etre est Healthy, false sinon.
	 */
	public boolean isHealthy() {
		return this.getState()==Etat.Healthy;
	}

	/**
	 * Methode permettant de savoir si l'Etre est Dead.
	 * 
	 * @return un booleen. Vrai si l'Etre est Dead, false sinon.
	 */
	public boolean isDead() {
		return this.getState()==Etat.Dead;
	}

	/**
	 * Methode permettant de savoir si l'Etre est Sick.
	 * 
	 * @return un booleen. Vrai si l'Etre est Sick, false sinon.
	 */
	public boolean isSick() {
		return this.getState()==Etat.Sick;
	}

	/**
	 * Methode permettant de savoir si l'Etre est Recovering.
	 * 
	 * @return un booleen. Vrai si l'Etre est Recovering, false sinon.
	 */
	public boolean isRecovering() {
		return this.getState()==Etat.Recovering;
	}

	/**
	 * Methode permettant de savoir si l'Etre est Contageous.
	 * 
	 * @return un booleen. Vrai si l'Etre est Contageous, false sinon.
	 */
	public boolean isContageous() {
		return this.getState()==Etat.Contageous;
	}

	/**
	 * Methode permettant de rendre un Etre Contageous suivant le temps d'incubation du virus ou d'un nombre aleatoire.
	 * 
	 * @param alternate Etre pouvant entrer dans l'Etat Sick.
	 * @param rdnum Nombre aleatoire definissant la probabilite que l'Etre soit Sick.
	 */
	public void setSick(Etre alternate, int rdnum) {
		if (this.getStateDay() == this.getVirus().getIncubation()) { // Verifie que les temps concorde entre le nombre de jour passe dans l'Etat Sick avec le Virus.
	       alternate.resetStateDay();
	       alternate.setState(Etat.Contageous);
	    } else if (rdnum == 0){
	       alternate.resetStateDay();
	       alternate.setState(Etat.Contageous);
	    } else {
	       alternate.incStateDay();
	    }
	}

	/**
	 * Methode permettant de rendre un Etre Healthy (L'Etat suivant de Recovering) suivant le temps de duree de l'Etat.
	 * 
	 * @param alternate Etre pouvant entrer dans l'Etat Recovering.
	 *
	 * @see Etat
	 */
	public void setRecovering(Etre alternate) {
		if (this.getStateDay() == this.getState().getTpsEtat()) { // Verifie que les temps concorde entre le nombre de jour passe dans l'Etat Recovering.
	       alternate.resetStateDay();
	       alternate.setState(Etat.Healthy);
	    } else {
	       alternate.incStateDay();
	    }
	}

	/**
	 * Methode permettant de rendre un Etre Recovering suivant le temps de duree de l'Etat. Un nombre aleatoire decidera si l'Etre meurt apres ou entre dans l'Etat Recovering
	 * 
	 * @param alternate Etre pouvant entrer dans l'Etat Sick.
	 * @param rdnum Nombre aleatoire definissant la probabilite que l'Etre soit Dead.
	 */
	public void setContageous(Etre alternate, int rdnum) {
		if (this.getStateDay() == this.getState().getTpsEtat()) { // Verifie que les temps concorde entre le nombre de jour passe dans l'Etat Contageous.
			Pig tryPig = new Pig();
			if (this.getClass() == tryPig.getClass()) {
				alternate.setState(Etat.Recovering);
			} else if(rdnum == 0) {
			    alternate.setState(Etat.Dead);
			} else {
			    alternate.setState(Etat.Recovering);
			}
			alternate.resetStateDay();
		}
		alternate.incStateDay();
	}
	
	/**
	 * Methode permettant d'avoir l'apparance physique d'un Etre.
	 * @return Un String avec la representation d'un Etre.
	 */
	public String getType() {
		return "E";
	}
	
	@Override
	  public boolean equals(Object o){
		  Etre tmp = (Etre)o;
		  return (this.getStateDay() == tmp.getStateDay())&&(this.getVirus().equals(tmp.getVirus()))&&(this.getState().equals(tmp.getState()));
	  }
	/**
	 * Methode permettant d'afficher un Etre (Un Etre est considerer comme vide dans le Terrain, car il n'a pas de caracteristiques physique).
	 * 
	 * @return Un String avec la representation d'un Etre sur le Terrain.
	 */
	public String toString() {
	    String result = "--";
		return result;
	}

}
