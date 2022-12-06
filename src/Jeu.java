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
                    // Création du Héro
                    System.out.println("Choisis ton nom de héros :  ");
                    String nomHeroChoisi = scannerMenuint.next();
                    Hero Hero = new Hero(nomHeroChoisi,  100, true );
                    // Lancement du jeu et création d'un donjon
                    Donjon donjon = new Donjon(10, "de la terreur");
                    // Boucle qui fais défiler les salles du donjon
                    for (int indexSalle = 0; indexSalle < donjon.obtenirDonjonNombrePiece(); indexSalle++){
                        // Entrée dans la pièce et description de celle-ci
                        int numeroPiece = indexSalle+1;
                        System.out.println("----------------------");
                        System.out.println("Piece n° "+ numeroPiece);
                        System.out.println(donjon.listeSalle[indexSalle].afficherNomSalle());
                        System.out.println("Fais attention " + nomHeroChoisi + " vous allez affronter "+ Donjon.afficherNomDuMonstre(donjon.listeSalle[indexSalle].obtenirMonstreSalle()));

                        // Combat contre le monstre : en continue tant que le monstre a des points de vie
                        // todo : voir quand le joueur n'a plus de points de vie
                        while(donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() > 0){
                            String choixDeArme; // correspond à l'arme utilisée
                            do {
                                System.out.println("***TAPE LE NOM DE TON ARME***");
                                System.out.println("Quelle arme souhaites-tu pour terrasser " + Donjon.afficherNomDuMonstre(donjon.listeSalle[indexSalle].obtenirMonstreSalle()) + " ?");
                                System.out.println("1.arc");
                                System.out.println("2.eau bénite");
                                System.out.println("3.epée");
                                System.out.println("4.flèche enflammée");
                                System.out.println("5.lance");
                                Scanner scannerStringArme = new Scanner(System.in);
                                choixDeArme = scannerStringArme.nextLine().toLowerCase();
                            } while ( !choixDeArme.equals("lance") && !choixDeArme.equals("eau bénite") && !choixDeArme.equals("epée") && !choixDeArme.equals("flèche enflammée") && !choixDeArme.equals("arc")); //|| !choixDeArme.equals("eau bénite")  || !choixDeArme.equals("epée")  || !choixDeArme.equals("flèche enflammée") || !choixDeArme.equals("lance") );
                            // todo : ecrire une variable avec un nombre de points de vie initial
                            //TODO : CHANGER LA PUISSANCE DES DEGATS EN FONCTION DE LA PUISSANCE ET DU MONSTRE
                            System.out.println("Puissance de l'attaque : " + Personnage.attaque(Hero.obtenirArmeUtilisee(choixDeArme), 10)+ "points!");
                            System.out.println("Vous avez attaqué! Il reste "+ donjon.listeSalle[indexSalle].obtenirMonstreSalle().pertePointDeVie(Personnage.attaque(Hero.obtenirArmeUtilisee(choixDeArme), 10)) + " points au Monstre!");
                            //System.out.println("il reste " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() + " points de vie au Monstre");

                            //Point de Vie avant-après attaque
                            System.out.println(nomHeroChoisi + " a " + Hero.obtenirPointDeVie() + " points avant l'attaque du monstre");
                            //Perte de point de Vie après attaque
                            //todo : faire les points en fonctions du monstre
                            Hero.pertePointDeVie(10);
                            System.out.println(nomHeroChoisi + " a " + Hero.obtenirPointDeVie() + " points après l'attaque du monstre");
                        }

                        // while tant que le monstre à de la vie le combat continue.

                        // Si le monstre est vaincu, récupérer un objet

                        //imaginons qu'il y a 1 potion sur le monstre
                        Hero.gainPointDeVie(3);
                        System.out.println("Bravo " + nomHeroChoisi + ", tu as maintenant " + Hero.obtenirPointDeVie() + " points!");

                        // Passer à la salle suivante
                    }
                    // Sortie des salls, la partie est finie
                }
            }while(choixMenu < 1 || choixMenu> 2 );
        }
    }
}