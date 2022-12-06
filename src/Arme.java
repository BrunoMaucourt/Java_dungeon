public abstract class Arme {

    // Attributs des armes
    protected String nomDeArme;
    protected int pointAttaqueArme;
    protected int pointAttaqueBonus;
    protected int tauxCoupCritique;
    protected int tauxAttaqueBonus;
    protected String nomAttaqueBonus;

    // Getter pour récupérer les informations des armes
    protected int obtenirPointAttaqueArme(){
        return this.pointAttaqueArme;
    }

    protected int obtenirPointAttaqueBonus(){
        return this.pointAttaqueBonus;
    }

    protected int obtenirtauxCoupCritique(){
        return this.tauxCoupCritique;
    }

    protected String obtenirnomAttaqueBonus(){
        return this.nomAttaqueBonus;
    }

    // Gestion de l'attaque bonus
    protected void attaqueBonus(){
        int tirageAleatoire = (int) (Math.random() * 100);
        if(tirageAleatoire <= this.tauxAttaqueBonus){
            //System.out.println("Attaque bonus : " + this.getname());
        }
    }
}
