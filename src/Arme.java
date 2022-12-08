public abstract class Arme {

    // Attributs des armes
    protected String nomDeArme;
    protected int pointAttaqueArme;
    protected int pointAttaqueCritique;
    protected int tauxCoupCritique;
    protected int tauxAttaqueBonus;
    protected String nomAttaqueBonus;

    // Getter pour récupérer les informations des armes
    protected int obtenirPointAttaqueArme(){
        return this.pointAttaqueArme;
    }

    protected int obtenirPointAttaqueCritique(){
        return this.pointAttaqueCritique;
    }

    protected int obtenirTauxCoupCritique(){
        return this.tauxCoupCritique;
    }
    protected int obtenitTauxAttaqueBonus(){
        return this.tauxAttaqueBonus;
    }

    protected String obtenirnomAttaqueBonus(){
        return this.nomAttaqueBonus;
    }

    protected String obtenirNomArme(){
        return this.nomDeArme;
    }

    // Gestion de l'attaque bonus
    protected static boolean probabiliteAttaqueBonus(Arme arme){
        int tirageAleatoire = (int) (Math.random() * 100);
        if(tirageAleatoire <= arme.obtenitTauxAttaqueBonus()){
            return true;
        }else{
            return false;
        }
    }
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
                System.out.println("Effet : le monstre est sonné par le coup d'épée");
                System.out.println("Il perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof FlecheEnflammee){
                System.out.println("Effet : le monstre a pris feu");
                System.out.println("Il perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points de vie");
            }else if(arme instanceof Hache){
                System.out.println("Effet : la hache de ton adversaire était bien aiguisée");
                System.out.println("Tu perd 10 points de vie");
                cible.pertePointDeVie(10);
                System.out.println("Il te reste " + cible.obtenirPointDeVie() + " / " + cible.obtenirPointDeVieInitial() + " points après l'attaque");
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
    protected int attaqueCoupCritique(Arme arme){
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
