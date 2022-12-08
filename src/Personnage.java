public abstract class Personnage {

    //Atttributs
    protected int pointDeVie;
    protected int pointDeVieInitial;
    protected int force;
    static boolean passerTourMonstre = false;
    static boolean passerTourHero = false;

    //Constructeur
    Personnage(int pointDeVie, int force) {
        this.pointDeVie = pointDeVie;
        this.pointDeVieInitial = pointDeVie;
        this.force = force;
    }

    public int obtenirPointDeVie() {
        if(this.pointDeVie < 0){
            return 0;
        }else{
            return this.pointDeVie;
        }
    }

    public int obtenirPointDeVieInitial() {
        return this.pointDeVieInitial;
    }

    public int obtenirForce(){
        return this.force;
    }

    public void ajouterForce(int valeurEffet){
        this.force += valeurEffet;
    }

    public void modifierForce(int valeurEffet){
        this.force = valeurEffet;
    }

    public void ajouterPointDeVieMax(int valeurEffet){
        this.pointDeVieInitial += valeurEffet;
    }

    public void modifierPointDeVieInitial(int valeurEffet){
        this.pointDeVieInitial = valeurEffet;
    }

    public int attaque(Arme arme) {
        int degats = this.force + arme.obtenirPointAttaqueArme() + arme.attaqueCoupCritique(arme);
        return degats;
    }

    public int gainPointDeVie (int pointDeVie) {
        int pointDeVieTemporaire = this.pointDeVie + pointDeVie;
        if (pointDeVieTemporaire < this.pointDeVieInitial){
            this.pointDeVie += pointDeVie;
        }else{
            this.pointDeVie = this.pointDeVieInitial;
        }
        return pointDeVie;
    }
    public int pertePointDeVie (int attaque){
        this.pointDeVie = pointDeVie - attaque;
        return pointDeVie;
    }

    public int pertePointDeVieTotal(){
        this.pointDeVie=0;
        return pointDeVie;
    }

    public void modifierPointDeVie(int pointDeVie){
        this.pointDeVie = pointDeVie;
    }
}