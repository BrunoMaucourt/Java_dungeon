public class Voleur extends Monstre{
    Voleur (int pointDeVie, int force) {
        super (pointDeVie, force);
        this.armeMonstre  = new Couteau("couteau", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
