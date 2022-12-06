public class Voleur extends Monstre{
    Voleur (int pointDeVie, boolean enVie) {
        super (pointDeVie, enVie);
        ArmeMonstre couteau = new Couteau("couteau", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
