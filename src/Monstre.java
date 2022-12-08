public abstract class Monstre extends Personnage {

    ArmeMonstre armeMonstre;
    Arme faiblesseArme;

    Monstre (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force);
        this.faiblesseArme = faiblesseArme;
    }

    public ArmeMonstre obtenirArmeMonstre(){
        return this.armeMonstre;
    }

    public Arme obtenirArmeFaiblesse(){
        return this.faiblesseArme;
    }
}
