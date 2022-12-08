public class PotionDeVie extends Potion{

    public PotionDeVie(int valeurEffet){
       super(valeurEffet);
    }

    void appliquerEffet(Personnage cible) {
        cible.gainPointDeVie(valeurEffet);
        System.out.println("Tu as trouvé une potion de vie");
        System.out.println("Tu as gagné " + valeurEffet + " points de vie");
    }
}
