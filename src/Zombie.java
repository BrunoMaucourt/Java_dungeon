public class Zombie extends Monstre{
    Zombie (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force, faiblesseArme);
        this.armeMonstre  = new Morsure("morsure", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
