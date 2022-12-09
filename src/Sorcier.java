public class Sorcier extends Monstre{
    /**
     * Constructeur d'un objet sorcier
     * Une arme (éclairs) est créée et associée au sorcier
     * @param pointDeVie
     * @param force
     * @param faiblesseArme arme à laquelle le sorcier est faible
     */
    Sorcier (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force, faiblesseArme);
        this.armeMonstre = new Eclairs("éclair", 10, 5,5, 5, "attaqueBonus");
        this.pointDeVie = pointDeVie;
    }
}
