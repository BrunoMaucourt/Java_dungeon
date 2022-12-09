/**
 * Classe donnant naissance aux différents types de potions.
 */
public abstract class Potion {
    protected int valeurEffet;

    /**
     * Constructeur de la classe Potion
     * @param valeurEffet
     */
    public Potion(int valeurEffet){
        this.valeurEffet = valeurEffet;
    }
    void appliquerEffet(){
    }

    /**
     * Détermine un nombre aléatoire correspondant au type de potion à créer
     * @return
     */
    public static int choisirPotionAleatoire(){
        int nombrePotionMax = 4;
        int nombrePotionMin = 1;
        int intervallePotion = nombrePotionMax - nombrePotionMin + 1;
        int nombreAleatoire = (int) (Math.random() * intervallePotion) + nombrePotionMin;
        return nombreAleatoire;
    }
}