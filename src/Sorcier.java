public class Sorcier extends Monstre{
    Sorcier (int pointDeVie, int force) {
        super(pointDeVie, force);
        this.armeMonstre = new Eclairs("éclair", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
