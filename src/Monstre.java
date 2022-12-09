public abstract class Monstre extends Personnage {

    ArmeMonstre armeMonstre;
    Arme faiblesseArme;

    /**
     * Redéfinition du constructeur de personnage
     * On rajoute l'arme à laquelle le monstre est faible
     * @param pointDeVie nombre de points de vie du monstre
     * @param force force du monstre
     * @param faiblesseArme arme à laquelle le monstre est faible
     */
    Monstre (int pointDeVie, int force, Arme faiblesseArme) {
        super(pointDeVie, force);
        this.faiblesseArme = faiblesseArme;
    }

    /**
     * Indique le nom de l'arme que le monstre possède
     * @return nom de l'arme
     */
    public ArmeMonstre obtenirArmeMonstre(){
        return this.armeMonstre;
    }

    /**
     * Indique à quelle arme le monstre est faible
     * @return nom de l'arme
     */
    public Arme obtenirArmeFaiblesse(){
        return this.faiblesseArme;
    }
}
