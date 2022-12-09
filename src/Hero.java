public class Hero extends Personnage{

    //attributs
    private String nomHero;
    protected boolean enVie;
    private static ArmeHero[] listeArme = new ArmeHero[5];
    private int score;

    /**
     * Constructeur du héro
     * Les armes de bases sont construites en même temps que le héro
     * @param nomHero
     * @param PointDeVie
     * @param force
     * @param enVie
     */
    Hero (String nomHero, int PointDeVie, int force, boolean enVie) {
        super(PointDeVie, force);
        this.nomHero = nomHero;
        this.enVie = enVie;
        listeArme [0]=new Epee("épée", 10, 5,5, 1, "Mort critique");
        listeArme [1]=new Lance("lance", 10, 5,5, 5, "attaqueBonus");
        listeArme [2]=new Arc("arc", 10, 5,5, 5, "attaqueBonus");
        listeArme [3]=new EauBenite("eau bénite", 10, 5,5, 5, "Paralysie");
        listeArme [4]=new FlecheEnflammee("flèche enflammée", 10, 5,5, 5, "attaqueBonus");
    }

    /**
     * Accéder à la liste des armes du héro
     * Un premier filtre est réaliser avant d'appeler cette méthode
     * @param nomArme l'utilisateur écris le nom de l'arme qu'il veut utiliser
     * @return renvoie l'arme correspondante contenu dans listeArme
     */
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

    /**
     * Renvoie le nom de l'arme stockée dans listeArme à l'indice utilisée en argument
     * @param numeroArme correspondant à l'indice de l'arme dans listeArme
     * @return nom de l'arme
     */
    public String obtenirNomArmeHero (int numeroArme) {
        return listeArme[numeroArme].obtenirNomArme();
    }

    public int obtenirNombreArmeHero() {
        return listeArme.length;
    }

    public String obtenirNomHero(){
        return this.nomHero;
    }

    /**
     * Modifier le nom du héro
     * @param nouveauNom
     */
    public void modifierNomHero(String nouveauNom){
        this.nomHero = nouveauNom;
    }

    /**
     * Renvoie le score du joueur
     * @return le score du joueur
     */
    public int obtenirScore() {
        return this.score;
    }

    /**
     * Augmente le score du joueur
     * @param valeur nombre à ajouter au score
     * @return le score mis à jour
     */
    public int augmenterScore(int valeur){
        this.score = this.score + valeur;
        return this.score;
    }

    /**
     * méthode Perte Point de vie
     * Si le nombre de point de vue descend en dessous de zéro, renvoie 0 pour éviter d'avoir un nombre négatif
     * @param attaqueDuMechant
     * @return nombre de points de vie
     */
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

    /**
     * Si le nombre de point de vie du héro est inférieur à 0, il est considéré comme mort
     * Envoie un message de fin de partie lorsque le héro meurt
     * @return une booléen qui indique si le héro est vivant
     */
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

    /**
     * Indique si le héro est actuellement en vie ou non
     * @return booléeant enVie
     */
    public boolean enVie() {
        return this.enVie;
    }

}