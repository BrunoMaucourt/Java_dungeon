public class Hero extends Personnage{

    //attributs
    protected String nomHero;
    protected int armes;
    protected int potion;

    // getter and setter
    public int getPotion() {
        return potion;
    }

    public void setPotion(int potion) {
        this.potion = potion;
    }

   // public String getNomHero()

    public void setNomHero(String nomHero) {
        this.nomHero = nomHero;
    }

    public int getArmes() {
        return armes;
    }

    public void setArmes(int armes) {
        this.armes = armes;
    }

    //constructeur
    Hero (String nomHero, int PointDeVie, int attaquesDuHero, int degatsRecus, boolean enVie) {
        super(PointDeVie, attaquesDuHero, degatsRecus, enVie);
        this.nomHero = nomHero;
        //Arme Arme = new Arme(1);
    }

    //méthode Perte Point de vie
    public int pertePointDeVie (int attaqueDuMechant){
        pointDeVie = pointDeVie - attaqueDuMechant;
        return pointDeVie;
    }

    //méthode pour augmenter les points de vie après potion
    public int gainPointDeVie (int potionTrouvée) {
        pointDeVie = pointDeVie + (10* potionTrouvée);
        return pointDeVie;
    }

}


