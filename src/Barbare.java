public class Barbare extends Monstre{

    Barbare (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force, faiblesseArme);
        this.armeMonstre = new Hache("hache", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
