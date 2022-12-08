import java.io.IOException;
import java.util.Scanner;
public class Jeu {
    public static void main(String[] args) throws IOException {

        boolean executionProgramme = true;
        int choixMenu;
        System.out.println("*************************");
        System.out.println("*");
        System.out.println("*   Java Dunegon");
        System.out.println("*   un jeu d'Andy, Aurélie et Bruno");
        System.out.println("*");
        System.out.println("*************************\n\n\n");
        Scanner scannerMenuint = new Scanner(System.in);
        System.out.println("Quel est ton nom héros ?  ");
        System.out.println("*** ECRIS TON NOM ***");
        String nomHeroChoisi = scannerMenuint.next();
        // Création du héro
        Hero hero = new Hero(nomHeroChoisi,100, 10,true);
        int nombreDeSalle = 2;
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
                }else if(choixMenu ==1) {
                    // Lancement du jeu et création d'un donjon
                    Donjon donjon = new Donjon(nombreDeSalle);
                    // Boucle qui fait défiler les salles du donjon
                    for (int indexSalle = 0; indexSalle < donjon.obtenirDonjonNombreSalle(); indexSalle++) {
                        if (hero.enVie()) {
                                /*
                                Entrée dans la pièce et description de celle-ci
                                Le numéro de la salle et le nom du monstre présent sont stockés dans des variables
                                */
                            int numeroPiece = indexSalle + 1;
                            String monstreActuel = Donjon.afficherNomDuMonstre(donjon.listeSalle[indexSalle].obtenirMonstreSalle());
                            String faiblesse = donjon.afficherFaiblesse(donjon.listeSalle[indexSalle].obtenirMonstreSalle());
                            System.out.println("\n----------------------");
                            System.out.println("Piece n° " + numeroPiece);
                            System.out.println(donjon.listeSalle[indexSalle].afficherNomSalle());
                            System.out.println("Fais attention " + nomHeroChoisi + " tu vas affronter un " + monstreActuel + " !");
                            System.out.println("Conseils pour les petits joueurs : le " + monstreActuel + " est sensible à " + faiblesse);

                            // Combat contre le monstre : on continue tant que le monstre a des points de vie
                            while (donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() > 0 && hero.enVie()) {
                                /*
                                    On récupère l'arme choisie par l'utilisateur.
                                    Pour éviter les problèmes de minuscules / majuscules, la réponse de l'utilisateur est convertie en minuscule
                                    Tant que la réponse ne correspond pas aux armes de la liste du héros, on continue à poser la question
                                */
                                if(Personnage.passerTourMonstre == false){
                                    System.out.println("\n----------------------");
                                    System.out.println("Le " + monstreActuel + " t'as attaqué avec son arme (" + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeMonstre().obtenirNomArme() + ")");
                                    int degatsAttaqueMonstre = donjon.listeSalle[indexSalle].obtenirMonstreSalle().attaque(donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeMonstre());
                                    System.out.println("Puissance de l'attaque : " + degatsAttaqueMonstre + " points de dégats !");
                                    //Point de Vie avant-après attaque
                                    System.out.println("Tu avais " + hero.obtenirPointDeVie() + " points de vie avant l'attaque du " + monstreActuel);
                                    //Perte de point de Vie après attaque
                                    hero.pertePointDeVie(degatsAttaqueMonstre);
                                    System.out.println("Il te reste " + hero.obtenirPointDeVie() + " / " + hero.obtenirPointDeVieInitial() + " points après l'attaque du " + monstreActuel);
                                    Arme.effetAttaqueBonus(Arme.probabiliteAttaqueBonus(donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeMonstre()),
                                            donjon.listeSalle[indexSalle].obtenirMonstreSalle(),
                                            hero,
                                            donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeMonstre());
                                    // Vérifier si le héro est toujours vivant
                                    hero.modifierStatusVie();
                                }else{
                                    Personnage.passerTourMonstre = false;
                                }
                                if (hero.enVie() && Personnage.passerTourHero == false) {
                                    String choixDeArme;
                                    do {
                                        System.out.println("\n*** ECRIS LE NOM DE TON ARME ***");
                                        System.out.println("Quelle arme souhaites-tu pour terrasser le " + monstreActuel + " ?");
                                        // Boucle permettant d'afficher la liste des armes
                                        for (int iIndex = 0; iIndex < hero.obtenirNombreArmeHero(); iIndex++) {
                                            System.out.println("- " + hero.obtenirNomArmeHero(iIndex));
                                        }
                                        Scanner scannerStringArme = new Scanner(System.in);
                                        choixDeArme = scannerStringArme.nextLine().toLowerCase();
                                    } while (!choixDeArme.equals(hero.obtenirNomArmeHero(0))
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
                                    System.out.println("\n----------------------");
                                    System.out.println("Tu as attaqué avec ton " + choixDeArme);
                                    int degatsAttaqueJoueur = (int) (hero.attaque(hero.obtenirArmeUtilisee(choixDeArme))*donjon.degatsFaiblesse(hero.obtenirArmeUtilisee(choixDeArme),donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeFaiblesse() ));
                                    System.out.println("Puissance de l'attaque : " + degatsAttaqueJoueur + " points de dégats !");
                                    System.out.println("Le " + monstreActuel + " avait " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() + " points de vie avant ton attaque");
                                    donjon.listeSalle[indexSalle].obtenirMonstreSalle().pertePointDeVie(degatsAttaqueJoueur);
                                    System.out.println("Il reste " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() + " / " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVieInitial() + " points de vie au " + monstreActuel);
                                    Arme.effetAttaqueBonus(Arme.probabiliteAttaqueBonus(hero.obtenirArmeUtilisee(choixDeArme)),
                                            hero,
                                            donjon.listeSalle[indexSalle].obtenirMonstreSalle(),
                                            hero.obtenirArmeUtilisee(choixDeArme));
                                }else{
                                    Personnage.passerTourHero = false;
                                }
                            }
                            /*
                                Le combat est finis et le héros a gagné
                                On peut récupérer un objet dans la pièce
                            */
                            if (hero.enVie()) {
                                System.out.println("\n----------------------");
                                System.out.println("Tu as battu le monstre");
                                System.out.println("Veux tu fouiller la pièce du donjon ?");
                                System.out.println("*** CHOISIS ***");
                                System.out.println("1. Oui, j'espère trouver un trésor");
                                System.out.println("2. Non, je veux continuer à avancer dans le donjon");
                                int choixFouille = scannerMenuint.nextInt();
                                if (choixFouille == 1) {
                                    /*
                                        On trouve une potion
                                     */
                                    int nombrePotionMax = 3;
                                    int nombrePotionMin = 1;
                                    int intervallePotion = nombrePotionMax - nombrePotionMin + 1;
                                    // Choisir un nombre aléatoire correspondant au type de monstre
                                    int typePotion = (int) (Math.random() * intervallePotion) + nombrePotionMin;
                                    if (typePotion == 1) {
                                        // potion de vie
                                        PotionDeVie potionVie = new PotionDeVie(30);
                                        potionVie.appliquerEffet(hero);
                                    }else if(typePotion ==2) {
                                        // potion de force
                                        PotionDeForce potionForce = new PotionDeForce(10);
                                        potionForce.appliquerEffet(hero);
                                    }else {
                                        // potion toxique
                                        PotionToxique potionToxique = new PotionToxique(10);
                                        potionToxique.appliquerEffet(hero);
                                        hero.modifierStatusVie();
                                    }
                                }
                            }
                            // Fin de la pièce, on passe à la suivante (ou au trésor à la fin de la boucle)
                        }
                    }
                }
                if (hero.enVie()) {
                    // Sortie des salles, la partie est finie
                    System.out.println("\n----------------------");
                    System.out.println("Bravo " + nomHeroChoisi + " tu es arrivé dans la dernière pièce du donjon.");
                    System.out.println("Tu as gagné cette partie mais oseras tu affronter un autre donjon ?\n");

                    /*
                           Menu pour sauvegarder
                    */
                    System.out.println("\n----------------------");
                    System.out.println("Veux tu sauvegarder ta progression avant le prohcain donjon ?");
                        System.out.println("*** CHOISIS ***");
                        System.out.println("1. Oui, je veux sauvegarder et faire une pause ici");
                        System.out.println("2. Non, je veux foncer dans le prochain donjon");
                        int choixSauvegarde = scannerMenuint.nextInt();
                        if (choixSauvegarde == 1) {
                            Sauvegarde.sauvegarder(hero.obtenirNomHero(),
                                    hero.obtenirPointDeVie(),
                                    hero.obtenirForce());
                        }
                    } else {
                        /*
                            Le hero a perdu la partie
                            On lui redonne ses points de vie initiaux pour la prochaine partie
                            On remet le booléen enVie à la valeur true
                         */
                        hero.gainPointDeVie(hero.obtenirPointDeVieInitial());
                        hero.modifierStatusVie();
                    }
            }while(choixMenu < 1 || choixMenu> 2);
        }
    }
}