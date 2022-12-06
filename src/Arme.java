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

    protected int obtenirtauxCoupCritique(){
        return this.tauxCoupCritique;
    }

    protected String obtenirnomAttaqueBonus(){
        return this.nomAttaqueBonus;
    }

    protected String obtenirNomArme(){
        return this.nomDeArme;
    }

    // Gestion de l'attaque bonus
    protected int attaqueBonus(){
        int tirageAleatoire = (int) (Math.random() * 100);
        if(tirageAleatoire <= this.tauxAttaqueBonus){
            return 0;//System.out.println("Attaque bonus : " + this.getname());
        }else{
            return  0;
        }
    }

    protected int attaqueCoupCritique(Arme arme){
        int tirageAleatoire = (int) (Math.random() * 100);
        if(tirageAleatoire <= arme.obtenirtauxCoupCritique()){
            System.out.println("Coup critique !");
            return obtenirPointAttaqueCritique();
        }else{
            return  0;
        }
    }
}
