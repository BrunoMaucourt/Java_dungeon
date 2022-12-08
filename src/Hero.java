public class Hero extends Personnage{

    //attributs
    private String nomHero;
    protected boolean enVie;
    private static ArmeHero[] listeArme = new ArmeHero[5];

    //constructeur
    Hero (String nomHero, int PointDeVie, int force, boolean enVie) {
        super(PointDeVie, force);
        this.nomHero = nomHero;
        this.enVie = enVie;
        listeArme [0]=new Epee("épée", 10, 5,5, 1, "attaqueBonus");
        listeArme [1]=new Lance("lance", 10, 5,5, 5, "attaqueBonus");
        listeArme [2]=new Arc("arc", 10, 5,5, 5, "attaqueBonus");
        listeArme [3]=new EauBenite("eau bénite", 10, 5,5, 5, "attaqueBonus");
        listeArme [4]=new FlecheEnflammee("flèche enflammée", 10, 5,5, 5, "attaqueBonus");
    }

    // Getter
    public static ArmeHero obtenirArmeUtilisee (String nomArme) {
        switch (nomArme){
            case "épée":
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

    public String obtenirNomArmeHero (int numeroArme) {
        return listeArme[numeroArme].obtenirNomArme();
    }

    public int obtenirNombreArmeHero() {
        return listeArme.length;
    }

    public String obtenirNomHero(){
        return this.nomHero;
    }

    //méthode Perte Point de vie
    public int pertePointDeVie (int attaqueDuMechant){
        /*
            Système pour éviter que le nombre de point de vie descende en dessous de 0
            Sinon lors de la prochaine partie, le héro commence avec un nombre de point vie négatif
         */
        int pointDeVieTemporaire = pointDeVie - attaqueDuMechant;
        if(pointDeVieTemporaire > 0){
            pointDeVie = pointDeVie - attaqueDuMechant;
        }else{
            pointDeVie = 0;
        }
        return pointDeVie;
    }

    public boolean modifierStatusVie() {
        if (pointDeVie > 0) {
            this.enVie = true;
        } else {
            this.enVie = false;
            System.out.println("\n----------------------");
            System.out.println("Tu as perdu la partie");
            System.out.println("Retourne à la salle de musculation avant de retenter ta chance");
        }
        return this.enVie;
    }

    public boolean enVie() {
        return this.enVie;
    }
}