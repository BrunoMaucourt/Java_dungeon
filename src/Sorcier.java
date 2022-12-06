public class Sorcier extends Monstre{
    Sorcier (int pointDeVie, boolean enVie) {
        super(pointDeVie, enVie);
        ArmeMonstre eclairs = new Eclairs("éclair", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
