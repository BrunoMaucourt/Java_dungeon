/**
 * La classe donjon permet de créer les salles
 * Elle contient également plusieurs méthodes nécessaires au cours du jeu
 */
public class Donjon {
    public  int nombreDeSalle;
    public String bienvenu = "Bienvenu dans le donjon ";
    public String nomDonjon;
    public String[] listeNomDonjon = {"de la terreur", "du nécromencien", "des marais", "maudit", "des succubes", "des quatre vents", "des démons"};
    public Salle[] listeSalle;

    /**
     * Créer un donjon et affiche son nom (choisi aléatoirement)
     * Créer les salles du donjon
     * @param nombreDeSalle
     */
    Donjon(int nombreDeSalle){
        this.nombreDeSalle = nombreDeSalle;
        // Choisir un nom aléatoire de donjon
        int choisirNom = (int) (Math.random() * listeNomDonjon.length);
        this.nomDonjon = listeNomDonjon[choisirNom];
        System.out.println("\n" + bienvenu + nomDonjon + "\n");
        // Créer la liste des salles
        this.listeSalle = new Salle [nombreDeSalle];
        for (int index = 0; index < nombreDeSalle; index ++){
            this.listeSalle[index] = new Salle();
        }
    }
    //Getter qui permet d'obtenir le nombre de salle du donjon
    public int obtenirDonjonNombreSalle(){
        return this.nombreDeSalle;
    }

    /**
     * Affiche le nom du monstre
     * @param monstre
     * @return une chaine de caractère avec le nom du monstre
     */
    public static String afficherNomDuMonstre(Monstre monstre){
        if (monstre instanceof Voleur) {
            return "voleur";
        }else if(monstre instanceof Sorcier){
            return "sorcier";
        }else if(monstre instanceof Troll){
            return "troll";
        }else if(monstre instanceof Barbare){
            return "barbare";
        }else if(monstre instanceof Zombie){
            return "zombie";
        }
        return "erreur";
    }

    /**
     * Indique la faiblesse du monstre
     * @param monstre
     * @return une chaine de caractère avec l'arme du héro contre laquelle le monstre est faible
     */
    public String afficherFaiblesse(Monstre monstre){
        if (monstre instanceof Voleur) {
            return "l'arc";
        }else if(monstre instanceof Sorcier){
            return "l'eau bénite";
        }else if(monstre instanceof Troll){
            return "la lance";
        }else if(monstre instanceof Barbare){
            return "l'épée";
        }else if(monstre instanceof Zombie){
            return "la flèche enflammée";
        }
        return "erreur";
    }

    public Double degatsFaiblesse(Arme armeUtilise, Arme faiblesseArme){
        if(armeUtilise == faiblesseArme){
            return 1.5;
        }else{
            return 1.0;
        }
    }
}