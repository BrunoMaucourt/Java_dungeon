public class PotionDeVieMax extends Potion{
    public PotionDeVieMax(int valeurEffet){
            super(valeurEffet);
    }
    void appliquerEffet(Personnage cible) {
        cible.ajouterPointDeVieMax(valeurEffet);
        System.out.println("Tu as trouvé une potion qui augmente ton nombre de point vie maximum");
        System.out.println("Tu as gagné " + valeurEffet + " points de vie");
    }
}