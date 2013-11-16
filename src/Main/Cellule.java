package Main;
import Element.*;

/**
 * Cellule est la classe contenant les differents Etre. Elle donne les informations globales les concernants.
 *
 * @author Roumegue Jeremy
 * @version 1.0.0
 */

public class Cellule {

	/**
	 * Le "xIndice" est la position vertical de la Cellule.
	 */
      public int xIndice;

	/**
	 * Le "yIndice" est la position horizontal de la Cellule.
	 */
      public int yIndice;

	/**
	 * Le "content" est l'Etre contenu dans la Cellule.
	 */
      public Etre content;


	/**
	 * Creer une Cellule vierge.
	 * 
	 * @param xIndice position vertical de la Cellule sur le tableau.
	 *
	 * @param yIndice position horizontal de la Cellule sur le tableau.
	 * 
	 */
      public Cellule(int xIndice, int yIndice) {
            this.xIndice = xIndice;
            this.yIndice = yIndice;
            this.content = new Etre();
      }

	/**
	 * Creer une Cellule avec un Etre defini en parametre.
	 * 
	 * @param xIndice position vertical de la Cellule sur le tableau.
	 *
	 * @param yIndice position horizontal de la Cellule sur le tableau.
	 * 
	 * @param cont Etre contenu dans la Cellule.
	 * 
	 */
      public Cellule(int xIndice, int yIndice, Etre cont) {
            this.xIndice = xIndice;
            this.yIndice = yIndice;
            this.content = cont;
      }

	/**
	 * Createur de Cellule par copie.
	 * 
	 * @param c1 Cellule devant etre copie passee en parametre.
	 * 
	 */
      public Cellule(Cellule c1){
            this.xIndice = c1.xIndice;
            this.yIndice = c1.yIndice;
            this.content = c1.getContent();
      }

	/**
	 * Renvoie une copie de la Celulle.
	 *
	 * @return Une Cellule utilisee par la fonction.
	 *
     */
      public Cellule getCellule() {
            return new Cellule (this.getX(), this.getY(), this.getContent());
      }

	/**
	 * Change le contenu de la Cellule.
	 *
	 * @param cont Etre passer en parametre pour le mettre dans la Cellule.
	 *
     */
      public void setContent(Etre cont) {
            this.content = cont;
      }

	/**
	 * Renvoie le contenu de la Cellule.
	 *
	 * @return L'Etre contenu dans la Cellule.
	 *
     */
      public Etre getContent () {
            return this.content;
      }

	/**
	 * Supprime le contenu d'une Cellule.
	 *
     */
      public void removeContent() {
            this.setContent(new Etre());
      }
	
	/**
	 * modificateur de position vertical de la Cellule.
	 *
	 * @param x future position vertical de la Cellule.
	 *
     */
      public void setX(int x) {
            this.xIndice = x;
      }

	/**
	 * modificateur de position horizontal de la Cellule.
	 *
	 * @param y future position horizontal de la Cellule.
	 *
     */
      public void setY(int y) {
            this.yIndice = y;
      }

	/**
	 * Accesseur de position vertical de la Cellule.
	 *
	 * @return La position vertical de la Cellule.
	 *
     */
      public int getX() {
            return this.xIndice;
      }

	/**
	 * Accesseur de position horizontal de la Cellule.
	 *
	 * @return La position horizontal de la Cellule.
	 *
     */
      public int getY() {
            return this.yIndice;
      }
	
	/**
	 * Verificateur de validite de la Cellule. La methode regarde le contenu de la Cellule et la validite de ses coordonnees
	 *
	 * @return Un booleen. true si la Cellule est vide, false si elle est remplie.
	 *
     */
      public boolean estValide() {
            return (this.getX() >= 1 && this.getX() <= 10) && (this.getY() >= 1 && this.getY() <= 10) && this.getContent().toString() == "--" ;
      }

	/**
	 * Verificateur de la bonne sante de la Cellule.
	 *
	 * @return Un booleen. true si la Cellule est en bonne sante, false sinon.
	 *
     */
      public boolean isHealthy() {
            return this.getContent().isHealthy() && !this.estValide();
      }

	/**
	 * Verificateur de la bonne regeneration de la Cellule.
	 *
	 * @return Un booleen. true si la Cellule est en cours de regeneration, false sinon.
	 *
     */
      public boolean isRecorvering() {
            return this.getContent().isRecovering() && !this.estValide();
      }

	/**
	 * Verificateur de la maladie de la Cellule.
	 *
	 * @return Un booleen. true si la Cellule est malade, false sinon.
	 *
     */
      public boolean isSick() {
            return this.getContent().isSick() && !this.estValide();
      }

	/**
	 * Verificateur de la mort de la Cellule.
	 *
	 * @return Un booleen. true si la Cellule est morte, false sinon.
	 *
     */
      public boolean isDead() {
            return this.getContent().isDead() && !this.estValide();
      }

	/**
	 * Verificateur de la contagion de la Cellule.
	 *
	 * @return Un booleen. true si la Cellule est contagieuse, false sinon.
	 *
     */
      public boolean isContageous() {
            return this.content.setContagieux() && !this.estValide();
      }

	/**
	 * Verificateur du contenu Humain de la Cellule. La methode va creer un Animal de type Homme et va le comparer avec l'Etre contenu dans la Cellule utilisee pour appeler la fonction.
	 *
	 * @return Un booleen. true si la Cellule contient un Homme, false sinon.
	 *
     */
      public boolean isHuman() {
			Homme test = new Homme();
            return (test.getClass() == this.getContent().getClass());
      }

	/**
	 * Verificateur du contenu Duck de la Cellule. La methode va creer un Animal de type Duck et va le comparer avec l'Etre contenu dans la Cellule utilisee pour appeler la fonction.
	 *
	 * @return Un booleen. true si la Cellule contient un Duck, false sinon.
	 *
     */
	  public boolean isDuck() {
			Duck test = new Duck();
            return (test.getClass() == this.getContent().getClass());
      }

	/**
	 * Verificateur du contenu Pig de la Cellule. La methode va creer un Animal de type Pig et va le comparer avec l'Etre contenu dans la Cellule utilisee pour appeler la fonction.
	 *
	 * @return Un booleen. true si la Cellule contient un Pig, false sinon.
	 *
     */
	  public boolean isPig() {
			Pig test = new Pig();
            return (test.getClass() == this.getContent().getClass());
      }

	/**
	 * Verificateur du contenu Chicken de la Cellule. La methode va creer un Animal de type Chicken et va le comparer avec l'Etre utilise pour appeler la fonction.
	 *
	 * @return Un booleen. true si la Cellule contient un Chicken, false sinon.
	 *
     */
	  public boolean isChicken() { 
			Chicken test = new Chicken();
            return (test.getClass() == this.getContent().getClass());
      }
	  
	  @Override
	  public boolean equals(Object o){
		  Cellule tmp = (Cellule)o;
		  return (this.getX() == tmp.getX())&&(this.getY() == tmp.getY())&&(this.getContent().equals(tmp.getContent()));
	  }

	/**
	 * Methode d'affichage d'une Cellule.
	 *
	 * @return Le contenu d'une Cellule en String.
	 *
     */
      public String toString () {
            String result;
            if (this.content != null) {
                result = this.content.toString();
            } else {
                result = "0";
            }
            return result;
      }
}
