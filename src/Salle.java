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
                monstre = new Voleur(90, -5,true);
                break;
            case 2:
                // Ajouter troll
                this.nomSalle =  "les oubliettes de l'effroi";
                monstre = new Troll(120, 5,true);
                break;
            case 3:
                // Ajouter sorcier
                this.nomSalle = "la bibliothèque maudite";
                monstre = new Sorcier(75, 2,true);
                break;
            case 4:
                // Ajouter barbare
                this.nomSalle = "la salle sanguinaire";
                monstre = new Barbare(100, 5,true);
                break;
            default:
                // Ajouter zombie
                this.nomSalle = "les toilettes de l'horreur";
                monstre = new Zombie(50, 0,true);
                break;
        }
    }

    public String afficherNomSalle(){
        String bienvenuSalle = "Tu rentres dans ";
        return bienvenuSalle + this.nomSalle;
    }
    //getter qui renvoie l'objet monstre de la salle
    public Monstre obtenirMonstreSalle(){
            return this.monstre;
    }
}
