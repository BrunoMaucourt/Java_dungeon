import java.util.Scanner;
public class Jeu {
    public static void main(String[] args) {

        boolean executionProgramme = true;
        int choixMenu;
        while (executionProgramme){
            do {
                System.out.println("Est tu sûr de  vouloir rentrer dans le donjon à tes risques et périls ?");
                System.out.println("*** CHOISIR ***");
                System.out.println("1. Oui, je suis prêt");
                System.out.println("2. Non, j'ai trop peur");
                Scanner scannerMenuint = new Scanner(System.in);
                choixMenu = scannerMenuint.nextInt();
                if (choixMenu == 2){
                    System.out.println("Reviens quand tu auras grandi petit aventurier.");
                    executionProgramme = false;
                }else if(choixMenu ==1){
                    // Lancement du jeu et création d'un donjon
                    Donjon donjon = new Donjon(10, "de la terreur");
                    // Boucle qui fais défiler les salles du donjon
                    for (int indexSalle = 0; indexSalle < donjon.obtenirDonjonNombrePiece(); indexSalle++){
                        // Entrée dans la pièce et description de celle-ci
                        int numeroPiece = indexSalle+1;
                        System.out.println("----------------------");
                        System.out.println("Piece n° "+ numeroPiece);
                        System.out.println(donjon.listeSalle[indexSalle].afficherNomSalle());
                        System.out.println("Faites attention vous allez affronter "+ Donjon.afficherNomDuMonstre(donjon.listeSalle[indexSalle].obtenirMonstreSalle()));
                        // Combat contre le monstre
                        // while tant que le monstre à de la vie le combat continue.

                        // Si le monstre est vaincu, récupérer un objet

                        // Passer à la salle suivante
                    }
                    // Sortie des salls, la partie est finie
                }
            }while(choixMenu < 1 || choixMenu> 2 );
        }
    }
}