public class Zombie extends Monstre{
    Zombie (int pointDeVie, int force, boolean enVie) {
        super (pointDeVie, force, enVie);
        this.armeMonstre  = new Morsure("morsure", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
