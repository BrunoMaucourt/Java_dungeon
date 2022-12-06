public class Donjon {
    public  int nombreDeSalle;
    public String bienvenu = "Bienvenu dans le donjon ";
    public String nomDonjon;
    public Salle[] listeSalle;

    Donjon(int nombreDeSalle, String nomDonjon){
        this.nombreDeSalle = nombreDeSalle;
        this.nomDonjon = nomDonjon;
        System.out.println(bienvenu + nomDonjon + "\n");
        // Créer la liste des salles
        this.listeSalle = new Salle [nombreDeSalle];
        for (int index = 0; index < nombreDeSalle; index ++){
            this.listeSalle[index] = new Salle();
        }
    }
    //Getter qui permet d'obtenir le nombre de pièce du donjon
    public int obtenirDonjonNombrePiece(){
        return this.nombreDeSalle;
    }

    // Renvoie le nom du monstre présent dans la pièce
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
}