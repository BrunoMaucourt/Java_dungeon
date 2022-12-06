public class Zombie extends Monstre{
    Zombie (int pointDeVie, boolean enVie) {
        super (pointDeVie, enVie);
        ArmeMonstre morsure = new Morsure("morsure", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
