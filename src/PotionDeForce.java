public class PotionDeForce extends Potion{
    public PotionDeForce(int valeurEffet){
        super(valeurEffet);
    }

    void appliquerEffet(Personnage cible) {
        cible.ajouterForce(valeurEffet);
        if(cible instanceof Hero){
            System.out.println("Tu as trouvé une potion de force");
            System.out.println("Tu as gagné " + valeurEffet + " points de force");
        }
    }
}