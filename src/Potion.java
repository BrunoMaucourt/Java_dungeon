public abstract class Potion {
    protected int valeurEffet;
    public Potion(int valeurEffet){
        this.valeurEffet = valeurEffet;
    }

    void appliquerEffet(){

    }

    public int obtenirValeurEffet(){
        return this.valeurEffet;
    }
}
