public abstract class Potion {
    protected int valeurEffet;
    public Potion(int valeurEffet){
        this.valeurEffet = valeurEffet;
    }
    void appliquerEffet(){
    }

    public static int choisirPotionAleatoire(){
        int nombrePotionMax = 4;
        int nombrePotionMin = 1;
        int intervallePotion = nombrePotionMax - nombrePotionMin + 1;
        int nombreAleatoire = (int) (Math.random() * intervallePotion) + nombrePotionMin;
        return nombreAleatoire;
    }
}
