public class Personnage {

    //Atttributs
    protected int pointDeVie;
    protected boolean enVie;

    //Constructeur
    Personnage(int pointDeVie, boolean enVie) {
        this.pointDeVie = pointDeVie;
        this.enVie = enVie;
    }

    public int obtenirPointDeVie() {
        return this.pointDeVie;
    }

    public static int attaque(Arme arme, int force) {
        int degats = force + arme.obtenirPointAttaqueArme() + arme.attaqueCoupCritique(arme);
        return degats;
    }

    public int pertePointDeVie (int attaque){
        this.pointDeVie = pointDeVie - attaque;
        return pointDeVie;
    }


    public boolean isEnVie() {
        if (pointDeVie <= 0) {
            this.enVie = true;
        } else {
            this.enVie = false;
        }
        return this.enVie;
    }
}