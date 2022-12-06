public class Troll extends Monstre {
    Troll (int pointDeVie, boolean enVie) {
        super(pointDeVie, enVie);
        ArmeMonstre massue = new Massue("massue", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
        }
    }
