public class Troll extends Monstre {
    /**
     * Constructeur du monstre troll
     * Une arme de monstre (massue) est créée et associée au monstre
     * @param pointDeVie
     * @param force
     * @param faiblesseArme arme à laquelle le monstre est faible
     */
    Troll (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force, faiblesseArme);
        this.armeMonstre  = new Massue("massue", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
        }
    }
