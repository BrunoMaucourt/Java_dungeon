public class Troll extends Monstre {
    Troll (int pointDeVie, int force, boolean enVie) {
        super(pointDeVie, force, enVie);
        this.armeMonstre  = new Massue("massue", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
        }
    }
