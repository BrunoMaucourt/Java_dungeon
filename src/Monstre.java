import org.w3c.dom.ls.LSOutput;

public abstract class Monstre extends Personnage {

    ArmeMonstre armeMonstre;

    Monstre (int pointDeVie, int force, boolean enVie) {
        super(pointDeVie, force, enVie);
    }

    public ArmeMonstre obtenirArmeMonstre(){
        return this.armeMonstre;
    }
}
