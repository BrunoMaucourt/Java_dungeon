public class Hero extends Personnage{

    //attributs
    protected String nomHero;
    protected String nomArme;
    protected int potion;
    public ArmeHero[] listeArme = new ArmeHero[5];

    //constructeur
    Hero (String nomHero, int PointDeVie, int force, boolean enVie) {
        super(PointDeVie, force, enVie);
        this.nomHero = nomHero;
        listeArme [0]=new Epee("épée", 10, 5,5, 5, "attaqueBonus");
        listeArme [1]=new Lance("lance", 10, 5,5, 5, "attaqueBonus");
        listeArme [2]=new Arc("arc", 10, 5,5, 5, "attaqueBonus");
        listeArme [3]=new EauBenite("eau bénite", 10, 5,5, 5, "attaqueBonus");
        listeArme [4]=new FlecheEnflammee("flèche enflammée", 10, 5,5, 5, "attaqueBonus");
    }

    // Getter
    public ArmeHero obtenirArmeUtilisee (String nomArme) {
        switch (nomArme){
            case "epee":
                return listeArme [0];
            case "lance":
                return listeArme [1];
            case "arc":
                return listeArme [2];
            case "eau bénite":
                return listeArme [3];
            default :
                return listeArme [4];

        }
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