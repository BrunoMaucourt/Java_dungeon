public class Voleur extends Monstre{
    Voleur (int pointDeVie, int force, boolean enVie) {
        super (pointDeVie, force, enVie);
        this.armeMonstre  = new Couteau("couteau", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
