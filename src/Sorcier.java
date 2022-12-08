public class Sorcier extends Monstre{
    Sorcier (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force, faiblesseArme);
        this.armeMonstre = new Eclairs("éclair", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
