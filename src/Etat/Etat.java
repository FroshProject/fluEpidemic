package src.Etat;

/**
 * Etat est un type énuméré contenant les Etats de bas ainsi que leur comportement.
 *
 * @author Roumegue Jérémy
 * @version 1.0.0
 */
public enum Etat {
	
	  //Etats de base, dont on a besoin lors de l'execution.
	  Contageous(3,true,"2"),
	  Dead (0,false,"☠"),
	  Healthy (0,false,"0"),
	  Recovering (4,false,"3"),
	  Sick (0,false,"1");

	  
	  /**
		 * Variable correspondant à la duree de l'Etat. 0 est la duree par defaut (infini).
		 *
		 */
	  private int tpsEtat;
	  
	  /**
		 * Variable permettant de savoir si un Etat est contagieux ou non.
		 *
		 */
	  private boolean isContageous;
	  
	  /**
		 * Variable permettant d'identifié l'Etat lors de l'affichage.
		 *
		 */
	  private String numEtat;
	   
	  //Constructeur
	  Etat(int tpsEtat, boolean isContageous, String numEtat){
	    this.tpsEtat=tpsEtat;
	    this.isContageous=isContageous;
	    this.numEtat=numEtat;
	  }
	  
	  
	  /**
		 * Methode permettant de connaitre la duree de l'etat.
		 *
		 * @return La duree de l'etat.
		 */
	  public int getTpsEtat(){
		  return tpsEtat;
	  }
	   
	  
	  /**
		 * Methode donnant la representation de l'etat Contageous.
		 *
		 * @return Un String permettant de reconaitre l'etat.
		 *
		 */
	  public String numEtat(){
	    return numEtat;
	  }
	   
	  /**
		 * Methode permettant de savoir si l'etat est contagieux.
		 *
		 * @return Un booleen permettant de savoir si l'etat est contagieux ou pas.
		 * 
		 */
	  public boolean setContagieux(){
		  return isContageous;
		  }
	  }
