import org.w3c.dom.ls.LSOutput;

public abstract class Monstre extends Personnage {

    ArmeMonstre armeMonstre;

    Monstre (int pointDeVie, int force) {
        super(pointDeVie, force);
    }

    public ArmeMonstre obtenirArmeMonstre(){
        return this.armeMonstre;
    }
}
