public abstract class Personnage {

    //Atttributs
    protected int pointDeVie;
    protected int pointDeVieInitial;
    protected int force;

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

    public int attaque(Arme arme) {
        int degats = this.force + arme.obtenirPointAttaqueArme() + arme.attaqueCoupCritique(arme);
        return degats;
    }

    public int gainPointDeVie (int pointDeVie) {
        this.pointDeVie += pointDeVie;
        return pointDeVie;
    }
    public int pertePointDeVie (int attaque){
        this.pointDeVie = pointDeVie - attaque;
        return pointDeVie;
    }
}