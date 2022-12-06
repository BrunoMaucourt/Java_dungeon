public class Barbare extends Monstre{

    Barbare (int pointDeVie, boolean enVie) {
        super(pointDeVie, enVie);
        ArmeMonstre hache = new Hache("hache", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
