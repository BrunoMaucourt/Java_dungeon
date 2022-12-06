public class Barbare extends Monstre{

    Barbare (int pointDeVie, int force, boolean enVie) {
        super(pointDeVie, force, enVie);
        this.armeMonstre = new Hache("hache", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
