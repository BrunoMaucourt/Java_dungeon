public class Salle {
    public Monstre monstre;
    public String nomSalle;
    private int typeMonstreMax = 5;
    private int typeMonstreMin = 1;
    private int range = typeMonstreMax - typeMonstreMin + 1;

    public Salle(){
        // Choisir un nombre aléatoire correspondant au type de monstre
        int typeDeMonstre = (int) (Math.random() * range) + typeMonstreMin;
        // Ajouter un monstre dans la salle et nommer la salle
        switch (typeDeMonstre){
            case 1:
                // Ajouter voleur
                this.nomSalle = "la salle des cauchemars";
                monstre = new Voleur();
                break;
            case 2:
                // Ajouter troll
                this.nomSalle =  "les oubliettes de l'effroi";
                monstre = new Troll();
                break;
            case 3:
                // Ajouter sorcier
                this.nomSalle = "la bibliothèque maudite";
                monstre = new Sorcier();
                break;
            case 4:
                // Ajouter barbare
                this.nomSalle = "la salle sanguinaire";
                monstre = new Barbare();
                break;
            default:
                // Ajouter zombie
                this.nomSalle = "les toilettes de l'horreur";
                monstre = new Zombie();
                break;
        }
    }

    public String afficherNomSalle(){
        String bienvenuSalle = "Vous rentrez dans ";
        return bienvenuSalle + this.nomSalle;
    }
    //getter qui renvoie l'objet monstre de la salle
    public Monstre obtenirMonstreSalle(){
            return this.monstre;
    }
}
