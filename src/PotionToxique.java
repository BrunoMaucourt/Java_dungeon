public class PotionToxique extends Potion{
    public PotionToxique(int valeurEffet) {
        super(valeurEffet);
    }

    void appliquerEffet(Personnage cible) {
        cible.pertePointDeVie(valeurEffet);
        System.out.println("Tu as trouvé une potion toxique");
        System.out.println("Tu as perdu " + valeurEffet + " points de vie");
    }
}
