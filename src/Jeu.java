import java.util.Scanner;
public class Jeu {
    public static void main(String[] args) {

        boolean executionProgramme = true;
        int choixMenu;
        System.out.println("*************************");
        System.out.println("*");
        System.out.println("*   Java Dunegon");
        System.out.println("*   un jeu d'Andy, Aurélie et Bruno");
        System.out.println("*");
        System.out.println("*************************\n\n\n\n");
        // Création du héro
        Scanner scannerMenuint = new Scanner(System.in);
        System.out.println("Quel est ton nom héros ?  ");
        System.out.println("*** ECRIS TON NOM ***");
        String nomHeroChoisi = scannerMenuint.next();
        Hero hero = new Hero(nomHeroChoisi,100, 10,true );
        int nombreDeSalle = 1;
        while (executionProgramme){
            do {
                /*
                Menu de départ du jeu
                 */
                System.out.println("\n" + nomHeroChoisi + " es tu sûr de  vouloir rentrer dans le donjon à tes risques et périls ?");
                System.out.println("*** CHOISIS ***");
                System.out.println("1. Oui, je suis prêt");
                System.out.println("2. Non, j'ai trop peur");
                choixMenu = scannerMenuint.nextInt();
                if (choixMenu == 2){
                    System.out.println("Reviens quand tu auras grandi petit aventurier.");
                    executionProgramme = false;
                }else if(choixMenu ==1){
                    // Lancement du jeu et création d'un donjon
                    Donjon donjon = new Donjon(nombreDeSalle);
                    // Boucle qui fait défiler les salles du donjon
                    for (int indexSalle = 0; indexSalle < donjon.obtenirDonjonNombreSalle(); indexSalle++){
                        /*
                        Entrée dans la pièce et description de celle-ci
                        Le numéro de la salle et le nom du monstre  présent sont stockés dans des variables
                        */
                        int numeroPiece = indexSalle+1;
                        String monstreActuel = Donjon.afficherNomDuMonstre(donjon.listeSalle[indexSalle].obtenirMonstreSalle());
                        System.out.println("\n----------------------");
                        System.out.println("Piece n° "+ numeroPiece);
                        System.out.println(donjon.listeSalle[indexSalle].afficherNomSalle());
                        System.out.println("Fais attention " + nomHeroChoisi + " tu vas affronter un "+ monstreActuel + " !");

                        // Combat contre le monstre : en continue tant que le monstre a des points de vie
                        // todo : voir quand le joueur n'a plus de points de vie
                        while(donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() > 0){
                            /*
                            On récupère l'arme choisie par l'utilisateur.
                            Pour éviter les problèmes de minuscules / majuscules, la réponse de l'utilisateur est convertie en minuscule
                            Tant que la réponse ne correspond pas aux armes de la liste du héros, on continue à poser la question
                             */
                            String choixDeArme;
                            do {
                                System.out.println("\n*** ECRIS LE NOM DE TON ARME ***");
                                System.out.println("Quelle arme souhaites-tu pour terrasser le " + monstreActuel + " ?");
                                // Boucle permettant d'afficher la liste des armes
                                for (int iIndex = 0; iIndex < hero.obtenirNombreArmeHero() ; iIndex++){
                                    System.out.println("- " + hero.obtenirNomArmeHero(iIndex));
                                }
                                Scanner scannerStringArme = new Scanner(System.in);
                                choixDeArme = scannerStringArme.nextLine().toLowerCase();
                            } while ( !choixDeArme.equals(hero.obtenirNomArmeHero(0))
                                    && !choixDeArme.equals(hero.obtenirNomArmeHero(1))
                                    && !choixDeArme.equals(hero.obtenirNomArmeHero(2))
                                    && !choixDeArme.equals(hero.obtenirNomArmeHero(3))
                                    && !choixDeArme.equals(hero.obtenirNomArmeHero(4))
                            );
                            /*
                            Combat contre le monstre
                            Les dégats sont calculés puis stockés dans une variable
                            Le nombre de point de vie restant est ensuite calculé
                             */

                            //TODO : CHANGER LA PUISSANCE DES DEGATS EN FONCTION DE LA PUISSANCE ET DU MONSTRE
                            // todo : le monstre peut-il contre-attaquer lorsqu'il est tué ?
                            System.out.println("\n----------------------");
                            System.out.println("Tu as attaqué avec ton " + choixDeArme );
                            int degatsAttaqueJoueur = hero.attaque(hero.obtenirArmeUtilisee(choixDeArme));
                            System.out.println("Puissance de l'attaque : " + degatsAttaqueJoueur + " points de dégats !");
                            System.out.println("Le " + monstreActuel + " avait " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie()  + " points de vie avant ton attaque");
                            donjon.listeSalle[indexSalle].obtenirMonstreSalle().pertePointDeVie(degatsAttaqueJoueur);
                            System.out.println("Il reste "+ donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() + " / " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVieInitial() + " points de vie au " + monstreActuel);

                            System.out.println("\n----------------------");
                            System.out.println("Le " + monstreActuel +" t'as attaqué avec son arme (" + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeMonstre().obtenirNomArme() + ")");
                            int degatsAttaqueMonstre = donjon.listeSalle[indexSalle].obtenirMonstreSalle().attaque(donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeMonstre());
                            System.out.println("Puissance de l'attaque : " + degatsAttaqueMonstre + " points de dégats !");
                            //Point de Vie avant-après attaque
                            System.out.println("Tu avais " + hero.obtenirPointDeVie() + " points de vie avant l'attaque du " + monstreActuel);
                            //Perte de point de Vie après attaque
                            //todo : faire les points en fonctions du monstre
                            hero.pertePointDeVie(degatsAttaqueMonstre);
                            System.out.println("Il te reste " + hero.obtenirPointDeVie() + " / " + hero.obtenirPointDeVieInitial()  + " points après l'attaque du " + monstreActuel);
                        }

                        /*
                        Le combat est finis et le héros a gagné
                        On peut récupérer un objet dans la pièce
                         */
                        System.out.println("\n----------------------");
                        System.out.println("Tu fouilles la pièce");
                        // todo : boucle while pour savoir si on veut fouiller la pièce
                        // todo : boucle while pour savoir si on veut utiliser la potion
                        //imaginons qu'il y a 1 potion sur le monstre
                        hero.gainPointDeVie(3);
                        System.out.println("Tu as trouvé une potion de vie sur le cadavre du monstre !");
                        System.out.println("Bravo " + nomHeroChoisi + ", tu as maintenant " + hero.obtenirPointDeVie() + " points de vie !");

                        // Fin de la pièce, on passe à la suivante (ou au trésors à la fin de la boucle)
                    }
                    // Sortie des salls, la partie est finie
                    System.out.println("\n----------------------");
                    System.out.println("Bravo " + nomHeroChoisi + " tu es arrivé dans la dernière pièce du donjon.");
                    System.out.println("Tu as gagné cette partie mais oseras tu affronter un autre donjon ?\n");
                }
            }while(choixMenu < 1 || choixMenu> 2 );
        }
    }
}