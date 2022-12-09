/**
 * Classe abstraite donnant naissance à ArmeHero et ArmeMonstre
 */
public abstract class Arme {

    // Attributs des armes
    protected String nomDeArme;
    protected int pointAttaqueArme;
    protected int pointAttaqueCritique;
    protected int tauxCoupCritique;
    protected int tauxAttaqueBonus;
    protected String nomAttaqueBonus;

    // Getter pour récupérer les informations des armes
    /**
     * indique le nombre de points de dommage de l'arme
     * @return
     */
    protected int obtenirPointAttaqueArme(){
        return this.pointAttaqueArme;
    }

    /**
     * Indique le nombre de points de dommage de l'arme lors d'un coup critique
     * @return le nombre de dommages
     */
    protected int obtenirPointAttaqueCritique(){
        return this.pointAttaqueCritique;
    }

    /**
     * Indique la probabilité d'un coup critique
     * @return le pourcentage de la probabilité
     */
    protected int obtenirTauxCoupCritique(){
        return this.tauxCoupCritique;
    }

    /**
     * Indique la probabilité d'une attaque bonus
     * @return le pourcentage de la probabilité
     */
    protected int obtenitTauxAttaqueBonus(){
        return this.tauxAttaqueBonus;
    }

    /**
     * Indique le nom de l'attaque bonus
     * @return
     */
    protected String obtenirnomAttaqueBonus(){
        return this.nomAttaqueBonus;
    }

    /**
     * Indique le nom de l'arme
     * @return le nom de l'arme sous forme de chaine de caractère
     */
    protected String obtenirNomArme(){
        return this.nomDeArme;
    }

    // Gestion de l'attaque bonus

    /**
     * Méthode permettant de déterminer si l'attaque bonus a lieu ou pas
     * @param arme utilisée
     * @return valeur booléen
     */
    protected static boolean probabiliteAttaqueBonus(Arme arme){
        int tirageAleatoire = (int) (Math.random() * 100);
        if(tirageAleatoire <= arme.obtenitTauxAttaqueBonus()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * L'Attaque bonus se lance après l'attaque "normale" si une certaine probabilité est atteinte
     * Les effets de cette attaque varient selon l'arme qui est utilisée
     * @param condition indique si l'attaque bonus a lieu ou pas
     * @param attaquant indique qui lance l'attaque spéciale
     * @param cible indique qui est la cible
     * @param arme indique l'arme utilisée
     */
    protected static void effetAttaqueBonus(boolean condition, Personnage attaquant, Personnage cible, Arme arme){
        if(condition == true){
            System.out.println("****");
            System.out.println("Attaque bonus de l'arme (" + arme.obtenirNomArme() + ")");
            if (arme instanceof Arc) {
                System.out.println("Effet : le monstre a été transpercé par une flèche");
                System.out.println("Il perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof Couteau){
                System.out.println("Effet : le couteau était empoisonné");
                System.out.println("Tu perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il te reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points après l'attaque");
            }else if(arme instanceof EauBenite){
                System.out.println("Effet : le monstre a été paralysé par l'eau bénite");
                System.out.println("Il ne peux pas jouer au prochain tour");
                Personnage.passerTourMonstre = true;
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof Eclairs){
                System.out.println("Effet : les éclairs t'ont foudroyés");
                System.out.println("Tu ne peux pas jouer au prochain tour");
                Personnage.passerTourHero = true;
                System.out.println("Il te reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points après l'attaque");
            }else if(arme instanceof Epee){
                System.out.println("Effet : le monstre est découpé en deux par le coup d'épée");
                System.out.println("Il perd tous ses points de vie");
                cible.pertePointDeVieTotal();
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof FlecheEnflammee){
                System.out.println("Effet : le monstre a pris feu");
                System.out.println("Il perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof Hache){
                int gainForce = 10;
                System.out.println("Effet : le barbare devient enragé, il gagne "+ gainForce +" points de force");
                PotionDeForce potionForce = new PotionDeForce(gainForce);
                potionForce.appliquerEffet(attaquant);
            }else if(arme instanceof Lance){
                System.out.println("Effet : le monstre a été transpercé par la lance");
                System.out.println("Il perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof Massue){
                System.out.println("Effet : tu as étais étourdit par le coup de massue");
                System.out.println("Tu ne peux pas jouer au prochain tour");
                Personnage.passerTourHero = true;
                System.out.println("Il te reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points après l'attaque");
            }else if(arme instanceof Morsure){
                System.out.println("Effet : la morsure était contaminée par des bactéries mangeuses de chair");
                System.out.println("Tu perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il te reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points après l'attaque");
            }
        }
    }

    /**
     * Calcul la probabilité du coup critique
     * Si la probabilité est atteinte les points d'attaques critiques sont renvoyés
     * Un message s'affiche pour indiquer qu'un coup critique a été effectué
     * @param arme utilisée pour l'attaque
     * @return le nombre de points de dommages causés par le coup critique (peut être nul)
     */
    protected int attaqueCoupCritique(Arme arme){
        // Nombre aléatoire entre 0 et 100
        int tirageAleatoire = (int) (Math.random() * 100);
        if(tirageAleatoire <= arme.obtenirTauxCoupCritique()){
            System.out.println("****");
            System.out.println("Coup critique,  " + obtenirPointAttaqueCritique() + " dégats en plus !");
            return obtenirPointAttaqueCritique();
        }else{
            return  0;
        }
    }
}
