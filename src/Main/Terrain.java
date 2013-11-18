package src.Main;
import java.util.Random;
import src.Element.*;
import src.Maladie.*;
import src.Etat.*;

/**
 * La classe Terrain est le modèle du jeu, on va gerer tous les deplacements, les gestions des etats, les gestions des variables et les gestions des contaminations.
 * 
 * @author Roumegue Jeremy
 * @version 1.0.0
 * 
 */
public class Terrain {
	/**
	 * Variable correspondant a la taille du tableau (carre)
	 */
	private int taille;
	
	/**
	 * Tableau de Cellule permettant de contenir les Etre et de les faires 'vivre'
	 */
	private Cellule leTerrain[][];
	
	/**
	 * Compteur du nombre de jour passe
	 */
	private int nbJour = 1;
	
	/**
	 * Instanciation du nombre aleatoire
	 */
	private Random rd = new Random();
	
	/**
	 * Instanciation du nombre homme present sur le Terrain
	 */
	private int nbHomme = 0;


	/**
	 * Constructeur par defaut d'un Terrain. Par defaut le Terrain fait une taille de 10x10 et contient uniquement des Cellules vide.
	 */
	public Terrain () {
		this.taille = 10;
		this.leTerrain = new Cellule[taille][taille];
		for(int i=0; i < 9; i++) { // Boucle permettant de mettre dans chaque cellule du tableau une Cellule vide.
		    for(int j=0; j< 9; j++) {
                leTerrain[i][j] = new Cellule(i, j);
		    }
		}
	}

	/**
	 * 
	 * Createur de Terrain avec un parametre impose, le parametre taille. Dans ce cas le Terrain sera instancie avec des Cellules contenant aleatoirement differents Etre.
	 * 
	 * @param Etaille Parametre int permettant de delimiter le tableau.
	 */
	public Terrain (int Etaille) {
		this.taille = Etaille;
		this.leTerrain = new Cellule[taille+2][taille+2];

		for(int i = 0; i < this.taille + 2; i++) {
		    	for(int j = 0; j < this.taille + 2; j++) {
		        	int rdnum = rd.nextInt(7); // Creer un nombre aleatoire entre 0 et 6.
					if(rdnum == 0 || rdnum == 4) { // il y a 2 chance sur 7 d'avoir un Homme dans le Tableau
		           		this.leTerrain[i][j] = new Cellule(i, j, new Homme());
		           		nbHomme++;
					} else if (rdnum == 1) { // il y a 1 chance sur 7 d'avoir un Chicken dans le Tableau
		            	this.leTerrain[i][j] = new Cellule(i, j, new Chicken());
					} else if (rdnum == 2) { // il y a 1 chance sur 7 d'avoir un Duck dans le Tableau
		            	this.leTerrain[i][j] = new Cellule(i, j, new Duck());
					} else if (rdnum == 3) { // il y a 1 chance sur 7 d'avoir un Pig dans le Tableau
		            	this.leTerrain[i][j] = new Cellule(i, j, new Pig());
					} else { // il y a 2 chance sur 7 d'avoir une Cellule vide
		            	this.leTerrain[i][j] = new Cellule(i, j);
					}
		    	}
		}
	}

	/**
	 * 
	 * Createur de Terrain avec deux parametres imposes, le parametre taille, et Etre. Dans ce cas le Terrain sera instancie avec des Cellules contenant des Etres definis en parametre.
	 * Cette methode est utilise pour faire les tests de contagion.
	 * 
	 * @param Etaille Parametre int permettant de delimiter le tableau.
	 * @param etre Contient un etre et en rempli le tableau.
	 */
	public Terrain (int Etaille, Etre etre) {
		this.taille = Etaille;
		this.leTerrain = new Cellule[taille+2][taille+2];

		for(int i = 0; i < this.taille+2; i++) {
	    	for(int j = 0; j< this.taille+2; j++) {
                this.leTerrain[i][j] = new Cellule(i, j, etre);
	    	}
		}
	}

	/**
	 * Dessiner va faire apparaitre le Terrain visuellement sur la console. Il fera egalement apparaitre les informations concernant les differents Etre (nombre de Dead, de Sick,...).
	 */
	public void dessiner() {
                System.out.println("\n--------------------- Jour " + this.nbJour + " ------------------\n"); // Affiche la date du jour actuel.
                for (int i = 1 ; i < this.taille; i++) {
                    System.out.println("\n---------------------------------------------------");
                    System.out.print("|");
                    for (int j = 1 ; j < this.taille; j++) {
						System.out.print(" "+ this.leTerrain[i][j].toString() +" |");
                        if (j == this.taille) { System.out.print("\n"); }
                    }
                }
                System.out.println("\n---------------------------------------------------");
                System.out.println("Nombre d'Homme mort                     : " + this.numHommeMort() +"/"+ this.getnbHomme()); // On affiche ci-dessous les differentes informations du Terrain et de ses Etres.
                System.out.println("Nombre de mort(s)                       : " + this.numMort()); // Affiche le nombre de Morts.
                System.out.println("Nombre de personne en bonne sante       : " + this.numHealthy()); // Affiche le nombre de personne en bonne sante.
                System.out.println("Nombre de personne malade               : " + this.numSick()); // Affiche le nombre de personne malade.
                System.out.println("Nombre de personne contagieuse          : " + this.numContageous()); // Affiche le nombre de personne contagieuse.
                System.out.println("Nombre de personne en cours de guerison : " + this.numRecorvering()); // Affiche le nombre de personne en cours de guerison.
                System.out.println("---------------------------------------------");
                System.out.println("Nombre total d'etre vivant              : " + (this.population() - this.numMort()) ); // Affiche la population en vie.

    }

	/**
	 * Methode clone permet de copier un terrain. Le terrain passer en parametre deviendra une copie du terrain utilise pour appeler la methode.
	 * @param tClone
	 */
    protected void clone(Terrain tClone){

        for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                tClone.leTerrain[i][j] = this.leTerrain[i][j].getCellule();
            }
        }
    }

    /**
     * Methode permettant de savoir le nombre d'Etre mort. La methode parcours le Terrain utiliser pour appeler la methode et verifie l'Etat de chaque Etre de chaque Cellule.
     * 
     * @return un nombre de type int correspondant au nombre de mort.
     */
    public int numMort() {
        int numDeMort = 0; // initialise le compteur a zero.
        for(int i = 1; i < this.taille; i++) { // Boucle sur toutes les cellules
	    	for(int j = 1; j< this.taille; j++) {
                if(this.leTerrain[i][j].getContent().isDead() && !(this.leTerrain[i][j].estValide())) numDeMort++; // Pour chaque Cellule morte, on incremente le compteur.
            }
        }
        return numDeMort; // on retourne le compteur.
    }
    
    /**
     * Methode permettant de savoir le nombre d'Homme mort. La methode parcours le Terrain utiliser pour appeler la methode et verifie l'Etat de chaque Homme de chaque Cellule.
     * 
     * @return un nombre de type int correspondant au nombre d'humain mort.
     */
    public int numHommeMort() {
        int numDeMort = 0; // initialise le compteur a zero.
        for(int i = 1; i < this.taille; i++) { // Boucle sur toutes les cellules
	    	for(int j = 1; j< this.taille; j++) {
                if(this.leTerrain[i][j].getContent().isDead() && !(this.leTerrain[i][j].estValide()) && (this.leTerrain[i][j].isHuman())) numDeMort++; // Pour chaque Cellule morte, on incremente le compteur.
            }
        }
        return numDeMort; // on retourne le compteur.
    }
    
    /**
     * Getteur de la variable nbHomme
     * 
     * @return Le nombre d'homme sur le terrain.
     */
    public int getnbHomme() {
        return nbHomme;
    }

    /**
     * Methode permettant de savoir le nombre d'Etre en cours de guerison. La methode parcours le Terrain utiliser pour appeler la methode et verifie l'Etat de chaque Etre de chaque Cellule.
     * 
     * @return Un int correspondant au nombre de personne en cours de guersion.
     */
    public int numRecorvering() {
        int nbRecorve = 0;
        for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                if(this.leTerrain[i][j].getContent().isRecovering() && !(this.leTerrain[i][j].estValide())) nbRecorve++;
            }
        }
        return nbRecorve;
    }

    /**
     * Methode permettant de connaitre le nombre de personne dans l'etat contagieuse.La methode parcours le Terrain utiliser pour appeler la methode et verifie l'Etat de chaque Etre de chaque Cellule.
     * 
     * @return Un int contenant le nombre de personne avec l'Etat Contageous.
     */
    public int numContageous() {
        int nbContageous = 0;
        for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                if(this.leTerrain[i][j].getContent().isContageous() && !(this.leTerrain[i][j].estValide())) nbContageous++;
            }
        }
        return nbContageous;
    }

    /**
     * Methode permettant de connaitre le nombre de personne en bonne sante.La methode parcours le Terrain utiliser pour appeler la methode et verifie l'Etat de chaque Etre de chaque Cellule.
     * 
     * @return Un int representant le nombre de personne avec l'Etat Healthy.
     */
    public int numHealthy() {
        int nbHeal = 0;
        for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                if(this.leTerrain[i][j].getContent().isHealthy() && !(this.leTerrain[i][j].estValide())) nbHeal++;
            }
        }

        return nbHeal;
    }

    /**
     * Methode permettant de connaitre le nombre de personne en bonne sante.La methode parcours le Terrain utiliser pour appeler la methode et verifie l'Etat de chaque Etre de chaque Cellule.
     * 
     * @return Un int representant le nombre de personne avec l'Etat Sick.
     */
    public int numSick() {
        int nbSick = 0;
        for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                if(this.leTerrain[i][j].getContent().isSick() && !(this.leTerrain[i][j].estValide())) nbSick++;
            }
        }
        return nbSick;
    }

    /**
     * Methode permettant de connaitre le nombre de personne totale. La methode parcours le Terrain utiliser pour appeler la methode et compte les cellules avec un Etre.
     * 
     * @return Un int representant le nombre de personne totale.
     */
    public int population() {
        int nbPop = 0;
        for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                if(!(this.leTerrain[i][j].estValide())){
                    nbPop++;
                }
            }
        }
        return nbPop;
    }

    /**
     * Methode permettant de contaminer aleatoirement les cellules adjacentes.
     * 
     * @param i abscisse de la cellule
     * @param j ordonnee de la cellule
     * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
     * @param rdnum Nombre aleatoire
     */
	public void contamineAlentour(int i, int j, Terrain alternative, int rdnum) {
		for(int x = i - 1; x < i + 1; x++) { // Boucle sur toutes les cellules autour (8 cases)
			for(int y = j - 1; y < j + 1; y++) {
				if(x != i && y != j){ // Elimine la Cellule qui infecte les autres
					Etat state1 = Etat.Sick; // Creation d'un nouvel Etat Sick pour le transmettre
					Virus virus1 = this.leTerrain[x][y].getContent().getVirus(); // On recupere le Virus transmit.
					if (alternative.leTerrain[x][y].getContent().getImmune() == null || 
						!(virus1 == alternative.leTerrain[x][y].getContent().getImmune())) { // Verification que la Cellule n'es pas immunise contre le Virus
						if(rdnum == 0 && this.leTerrain[x][y].isHealthy()) { // Verification de la bonne sante de la cellule a contaminer.
							alternative.leTerrain[x][y].getContent().setState(state1); // Mise en place de l'Etat
							alternative.leTerrain[x][y].getContent().setVirus(virus1); // Mise en place du Virus
						}
					}
				}
			}
		}
	}

	/**
	 * Methode permettant de verifier le type de contamination et de redistribuer les contaminations avec les bonnes variables.
	 * 
	 * @param i Abscisse de la Cellule
	 * @param j Ordonnee de la Cellule
	 * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
	 */
	public void checkContamination(int i, int j, Terrain alternative) {
		if (this.leTerrain[i][j].isHuman()) { // Si c'est un Homme on utilise la methode faite pour.
			contamineAlentourHuman(i, j, alternative);
		} else if (this.leTerrain[i][j].isPig()) { // De meme pour le Pig 
			contamineAlentourCochon(i, j, alternative);
		} else if (this.leTerrain[i][j].isChicken()) { // Le Chicken
			contamineAlentourChicken(i, j, alternative);
		} else if (this.leTerrain[i][j].isDuck()) { // Et le Duck
			contamineAlentourDuck(i, j, alternative);
		}

		if (this.numSick() == 0) { // Si le nombre de personne apres l'infectation est de 0, alors les Pig peuvent generer la maladie eux-meme et redevenir malade et continuer la propagation.
			this.setABadLuckPigSick(alternative);
		}
	}

	/**
	 * Methode permettant a un Pig de generer la maladie a nouveau et donc de la redistribuer.
	 * 
	 * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
	 */
	public void setABadLuckPigSick(Terrain alternative) {
		for(int i = 1; i < this.taille; i++) { // Parcours le Terrain
	    	for(int j = 1; j< this.taille; j++) {
                int rdnum = rd.nextInt(4); // Creer un chiffre en 1 et 4
				Virus virus = Virus.H5N1; // Instancie le nouveau virus
                if ((rdnum == 0 && this.leTerrain[i][j].isPig() && !this.leTerrain[i][j].isDead()) &&
					(alternative.leTerrain[i][j].isPig() && !alternative.leTerrain[i][j].isDead())) {
					alternative.leTerrain[i][j].getContent().setState(Etat.Sick);
					alternative.leTerrain[i][j].getContent().setVirus(virus);
				}
	    	}
		}
	}

	/**
	 * Methode permettant de contaminer les cellules alentours avec la probabilite correspondant aux Pig
	 * 
	 * @param i Abscisse de la Cellule
	 * @param j Ordonnee de la Cellule
	 * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
	 */
	public void contamineAlentourCochon(int i, int j, Terrain alternative){
		int rdnum = rd.nextInt(1);
		contamineAlentour(i, j, alternative, rdnum);
	}

	/**
	 * Methode permettant de contaminer les cellules alentours avec la probabilite correspondant aux Chicken
	 * 
	 * @param i Abscisse de la Cellule
	 * @param j Ordonnee de la Cellule
	 * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
	 */
	public void contamineAlentourChicken(int i, int j, Terrain alternative){
		int rdnum = rd.nextInt(3);
		contamineAlentour(i, j, alternative, rdnum);
	}

	/**
	 * Methode permettant de contaminer les cellules alentours avec la probabilite correspondant aux Homme
	 * 
	 * @param i Abscisse de la Cellule
	 * @param j Ordonnee de la Cellule
	 * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
	 */
	public void contamineAlentourHuman(int i, int j, Terrain alternative){
		int rdnum = rd.nextInt(2);
		contamineAlentour(i, j, alternative, rdnum);
	}

	/**
	 * Methode permettant de contaminer les cellules alentours avec la probabilite correspondant aux Duck
	 * 
	 * @param i Abscisse de la Cellule
	 * @param j Ordonnee de la Cellule
	 * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
	 */
	public void contamineAlentourDuck(int i, int j, Terrain alternative){
		int rdnum = rd.nextInt(5);
		contamineAlentour(i, j, alternative, rdnum);
	}

	/**
	 * Methode permettant de faire varier les Etat.
	 */
    public void vie () {
        Terrain alternative = new Terrain(this.taille, new Etre()); // Creer un Nouveau Terrain 
        this.clone(alternative); // Remplacement du terrain juste creer par le terrain d'origine
		for(int i = 1; i < this.taille; i++) {
			for(int j = 1 ; j< this.taille; j++) { // On parcours toutes les Cellules
				Etre actuel = this.leTerrain[i][j].getContent(); // Afin de rendre le code plus lisibles, on simplifie le contenu de la Cellule

				if (this.leTerrain[i][j].isContageous()){ // Si la Cellulle est contagieuse, on contamine.
					this.checkContamination(i,j,alternative);
					int rdnum = rd.nextInt(2);
					actuel.setContageous(alternative.leTerrain[i][j].getContent(), rdnum);
				} else if (actuel.isRecovering()){ // si la Cellule est en cours de guerison, elle continu a se soigner.
					actuel.setRecovering(alternative.leTerrain[i][j].getContent());
				} else if (this.leTerrain[i][j].isSick()){ // Si elle est malade on s'occupe de la maladie.
					int rdnum = rd.nextInt(2);
					actuel.setSick(alternative.leTerrain[i][j].getContent(), rdnum);
				}	
	    	}
		}
		alternative.clone(this); // Renvoie le terrain clone dans le terrain d'origine
    }

    /**
     * Methode permettant de faire bouger aleatoirement les Etre dans le terrain.
     * 
     * @param i abscisse de la cellule
     * @param j ordonnee de la cellule
     * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
     * @param rdnum Nombre aleatoire
     */
	public void move(Terrain alternative, int i, int j, int rdnum) {
		if (!this.leTerrain[i][j].isDead() && !this.leTerrain[i][j].estValide()){
            if(rdnum == 0 && this.leTerrain[i][j+1].estValide() && alternative.leTerrain[i][j+1].estValide()) {
                bougerDroite(alternative, i, j,rdnum);
            } else if (rdnum == 1 && this.leTerrain[i+1][j].estValide() && alternative.leTerrain[i+1][j].estValide()) {
                bougerBas(alternative, i, j,rdnum);
            } else if (rdnum == 2 && this.leTerrain[i-1][j].estValide() && alternative.leTerrain[i-1][j].estValide()) {
                bougerHaut(alternative, i, j,rdnum);
            } else if (rdnum == 3 && this.leTerrain[i][j-1].estValide() && alternative.leTerrain[i][j-1].estValide()) {
                bougerGauche(alternative, i, j,rdnum);
            }
        }
	}
	
	/**
     * Methode permettant de faire bouger les Etre vers la droite.
     * 
     * @param i abscisse de la cellule
     * @param j ordonnee de la cellule
     * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
     * @param rdnum Nombre aleatoire
     */
	public void bougerDroite(Terrain alternative, int i, int j, int rdnum) {
		alternative.leTerrain[i][j+1] = new Cellule(this.leTerrain[i][j].getCellule());
        this.leTerrain[i][j].removeContent(); // Supprime l'Etre sur son ancien placement du terrain d'origine.
        alternative.leTerrain[i][j].removeContent(); // Supprime l'Etre sur son ancien placement du terrain clone.
	}

	/**
     * Methode permettant de faire bouger les Etre vers la gauche.
     * 
     * @param i abscisse de la cellule
     * @param j ordonnee de la cellule
     * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
     * @param rdnum Nombre aleatoire
     */
	public void bougerGauche(Terrain alternative, int i, int j, int rdnum) {
		alternative.leTerrain[i][j-1] = new Cellule(this.leTerrain[i][j].getCellule());
        this.leTerrain[i][j].removeContent();
        alternative.leTerrain[i][j].removeContent();
	}

	/**
     * Methode permettant de faire bouger les Etre vers le haut.
     * 
     * @param i abscisse de la cellule
     * @param j ordonnee de la cellule
     * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
     * @param rdnum Nombre aleatoire
     */
	public void bougerHaut(Terrain alternative, int i, int j, int rdnum) {
		alternative.leTerrain[i-1][j] = new Cellule(this.leTerrain[i][j].getCellule());
        this.leTerrain[i][j].removeContent();
        alternative.leTerrain[i][j].removeContent();
	}

	/**
     * Methode permettant de faire bouger les Etre vers le bas.
     * 
     * @param i abscisse de la cellule
     * @param j ordonnee de la cellule
     * @param alternative Copie du terrain d'origine (Terrain qui subira les modifications)
     * @param rdnum Nombre aleatoire
     */
	public void bougerBas(Terrain alternative, int i, int j, int rdnum) {
		alternative.leTerrain[i+1][j] = new Cellule(this.leTerrain[i][j].getCellule());
        this.leTerrain[i][j].removeContent();
        alternative.leTerrain[i][j].removeContent();
	}

	/**
	 * Methode permettant de mettre en vie le Terrain et de l'afficher.
	 */
    public void jourSuivant () {
        Terrain alternative = new Terrain(this.taille, new Etre());
        this.clone(alternative);

		for(int i = 1; i < this.taille; i++) {
	    	for(int j = 1; j< this.taille; j++) {
                int rdnum = rd.nextInt(4);
                move(alternative, i, j, rdnum);
	    	}
		}
		alternative.clone(this);
		this.vie();
		this.nbJour++;
		this.dessiner();
    }
    
    @Override
    public boolean equals(Object o){
    	Terrain tmp = (Terrain)o;
    	boolean struct =(this.taille == tmp.taille)&&(this.nbJour == tmp.nbJour)&&(this.nbHomme == tmp.nbHomme);
    	if(struct){
    		for(int i=0;i<taille;i++){
    			for(int j=0;j<taille;j++){
    				if(!(this.leTerrain[i][j].equals(tmp.leTerrain[i][j]))){
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }
	public static void main(String [] args) {
		Terrain t = new Terrain(30);
		t.dessiner();
        do {
			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (InterruptedException ie) {}
            t.jourSuivant();
        } while (t.nbJour <= 365 || (t.numHommeMort() == t.getnbHomme()));
    }
}
