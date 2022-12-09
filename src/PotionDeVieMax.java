/**
 * Potion permettant d'augmenter le nombre de points maximums
 */
public class PotionDeVieMax extends Potion{
    /**
     * Constructeur de potion de vie max
     * @param valeurEffet
     */
    public PotionDeVieMax(int valeurEffet){
            super(valeurEffet);
    }
    /**
     * Effet de la potion de vie max
     * Affiche un message lorsque la potion est utilisée
     * @param cible
     */
    void appliquerEffet(Personnage cible) {
        cible.ajouterPointDeVieMax(valeurEffet);
        System.out.println("Tu as trouvé une potion qui augmente ton nombre de point vie maximum");
        System.out.println("Tu as gagné " + valeurEffet + " points de vie");
    }
}