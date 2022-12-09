import java.io.IOException;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

/**
 * Classe principale du jeu
 */
public class Jeu {
    public static void main(String[] args) throws IOException {

        /*
        Variables chargées en début de partie
        Création d'un héro
         */
        boolean executionProgramme = true;
        int choixMenu;
        int nombreDeSalle = 5;
        final int VALEURVIEHEROINITIAL = 200;
        final int VALEURFORCEHEROINITIAL = 10;
        final int VALEURPOTIONVIE = 30;
        final int VALEURPOTIONTOXIQUE = 10;
        final int VALEURPOTIONFORCE = 10;
        final int VALEURPOTIONVIEMAX = 10;
        Hero hero = new Hero("Hero",VALEURVIEHEROINITIAL, VALEURFORCEHEROINITIAL,true);
        int choixMenuPrincipal;
        boolean finMenuPrincipal = false;
        int choixChargement;

        System.out.println("*************************");
        System.out.println("*");
        System.out.println("*   Java Dunegon");
        System.out.println("*   un jeu d'Andy, Aurélie et Bruno");
        System.out.println("*");
        System.out.println("*************************\n\n");
        Scanner scannerMenu = new Scanner(System.in);
        while (finMenuPrincipal == false){
            System.out.println("\n\nBienvenu dans JAVA dungeon.");
            do{
                System.out.println("\n*** CHOISIS ***");
                System.out.println("1. Commencer une nouvelle partie");
                System.out.println("2. Charger une ancienne partie");
                System.out.println("3. Quitter le jeu");
                choixMenuPrincipal = scannerMenu.nextInt();
                if(choixMenuPrincipal != 1 && choixMenuPrincipal != 2 && choixMenuPrincipal != 3){
                    System.out.println("\n*****");
                    System.out.println("Fais le bon choix si tu ne veux pas être mordu par un vampire");
                }
            }while(choixMenuPrincipal != 1 && choixMenuPrincipal != 2 && choixMenuPrincipal != 3);
        /*
        En fonction du choix du joueur
        1 choix du nom du héro (créée précédemment)
        2 les données d'un ancien héro sont chargées
        3 quitter le jeu
         */
            if(choixMenuPrincipal == 1){
                Scanner scannerMenuPrincipal = new Scanner(System.in);
                System.out.println("Quel est ton nom héros ?  ");
                System.out.println("*** ECRIS TON NOM ***");
                String nomHeroChoisi = scannerMenuPrincipal.next();
                hero.modifierNomHero(nomHeroChoisi);
                finMenuPrincipal = true;
            }else if(choixMenuPrincipal == 2){
                String chargement = Sauvegarde.charger();
                if(chargement == null){
                    System.out.println("Aucunes données enregistrées");
                }else{
                    String[] donneesChargees = chargement.split(",");
                    String nomHero = donneesChargees[0].trim();
                    int nombrePointDeVie = parseInt(donneesChargees[1].trim());
                    int nombrePointDeVieInitial = parseInt(donneesChargees[2].trim());
                    int nombreForce = parseInt(donneesChargees[3].trim());
                    int nombreScore = parseInt(donneesChargees[4].trim());
                    System.out.println("****");
                    System.out.println("Données chargées");
                    System.out.println("Nom du héro = " + nomHero);
                    System.out.println("Nombre de point de vie = " + nombrePointDeVie);
                    System.out.println("Nombre de point de vie totaux = " + nombrePointDeVieInitial);
                    System.out.println("Force = " + nombreForce);
                    System.out.println("Score = " + nombreScore);
                    do{
                        System.out.println("\n*** CHOISIS ***");
                        System.out.println("1. Commencer une partie avec ces données");
                        System.out.println("2. Retourner au menu");
                        choixChargement = scannerMenu.nextInt();
                    }while(choixMenuPrincipal != 1 && choixMenuPrincipal != 2);
                    if(choixChargement == 1){
                        hero.modifierNomHero(nomHero);
                        hero.modifierPointDeVie(nombrePointDeVie);
                        hero.modifierPointDeVieInitial(nombrePointDeVieInitial);
                        hero.modifierForce(nombreForce);
                        hero.augmenterScore(nombreScore);
                        finMenuPrincipal = true;
                    }
                }
            }else {
                finMenuPrincipal = true;
                executionProgramme = false;
            }
        }
        while (executionProgramme){
            do {
                /*
                Menu de départ du jeu
                 */
                System.out.println("\n" + hero.obtenirNomHero() + " es tu sûr de  vouloir rentrer dans le donjon à tes risques et périls ?");
                System.out.println("*** CHOISIS ***");
                System.out.println("1. Oui, je suis prêt");
                System.out.println("2. Non, j'ai trop peur");
                choixMenu = scannerMenu.nextInt();
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
                            System.out.println("Fais attention " + hero.obtenirNomHero() + " tu vas affronter un " + monstreActuel + " !");
                            System.out.println("Conseil pour ceux qui ont dormis durant les cours : le " + monstreActuel + " est sensible à " + faiblesse);

                            // Combat contre le monstre : on continue tant que le monstre a des points de vie
                            while (donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() > 0 && hero.enVie()) {
                                /*
                                    On récupère l'arme choisie par l'utilisateur.
                                    Pour éviter les problèmes de minuscules / majuscules, la réponse de l'utilisateur est convertie en minuscule
                                    Tant que la réponse ne correspond pas aux armes de la liste du héros, on continue à poser la question
                                */
                                if (Personnage.passerTourMonstre == false) {
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
                                } else {
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
                                    Attaque du joueur contre le monstre
                                    Les dégâts sont calculés puis stockés dans une variable
                                    Le nombre de point de vie restant est ensuite calculé
                                     */
                                    System.out.println("\n----------------------");
                                    System.out.println("Tu as attaqué avec ton " + choixDeArme);
                                    int degatsAttaqueJoueur = (int) (hero.attaque(hero.obtenirArmeUtilisee(choixDeArme)) * donjon.degatsFaiblesse(hero.obtenirArmeUtilisee(choixDeArme), donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirArmeFaiblesse()));
                                    System.out.println("Puissance de l'attaque : " + degatsAttaqueJoueur + " points de dégats !");
                                    System.out.println("Le " + monstreActuel + " avait " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() + " points de vie avant ton attaque");
                                    donjon.listeSalle[indexSalle].obtenirMonstreSalle().pertePointDeVie(degatsAttaqueJoueur);
                                    System.out.println("Il reste " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVie() + " / " + donjon.listeSalle[indexSalle].obtenirMonstreSalle().obtenirPointDeVieInitial() + " points de vie au " + monstreActuel);
                                    Arme.effetAttaqueBonus(Arme.probabiliteAttaqueBonus(hero.obtenirArmeUtilisee(choixDeArme)),
                                            hero,
                                            donjon.listeSalle[indexSalle].obtenirMonstreSalle(),
                                            hero.obtenirArmeUtilisee(choixDeArme));
                                } else {
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
                                int choixFouille = scannerMenu.nextInt();
                                System.out.println("\n----------------------");
                                System.out.println("Résultat de la fouille");
                                if (choixFouille == 1) {
                                    /*
                                        On trouve une potion
                                        Le type de potion est choisi aléatoirement
                                     */
                                    int typePotion = Potion.choisirPotionAleatoire();
                                    if (typePotion == 1) {
                                        // potion de vie
                                        PotionDeVie potionVie = new PotionDeVie(VALEURPOTIONVIE);
                                        potionVie.appliquerEffet(hero);
                                    } else if (typePotion == 2) {
                                        // potion de force
                                        PotionDeForce potionForce = new PotionDeForce(VALEURPOTIONFORCE);
                                        if (hero.obtenirForce() < VALEURFORCEHEROINITIAL + 50) {
                                            potionForce.appliquerEffet(hero);
                                        } else {
                                            System.out.println("Tu as trouvé une potion de force");
                                            System.out.println("Il n'y a pas d'effet car ta force est déjà à son maximum (le dopage n'est pas autorisé ici)");
                                        }
                                    } else if (typePotion == 3) {
                                        // potion de PV max
                                        PotionDeVieMax potionDeVieMax = new PotionDeVieMax(VALEURPOTIONVIEMAX);
                                        if (hero.obtenirPointDeVieInitial() < VALEURVIEHEROINITIAL + 100) {
                                            potionDeVieMax.appliquerEffet(hero);
                                        } else {
                                            System.out.println("Tu as trouvé une potion augmentant le nombre de points vie maximum");
                                            System.out.println("Il n'y a pas d'effet car ton nombre de point de vie est déjà à son maximum (le dopage n'est pas autorisé ici)");
                                        }
                                    } else {
                                        // potion toxique
                                        PotionToxique potionToxique = new PotionToxique(VALEURPOTIONTOXIQUE);
                                        potionToxique.appliquerEffet(hero);
                                        // Vérifier si le joueur est toujours vivant après avoir perdu de la vie
                                        hero.modifierStatusVie();
                                    }
                                }
                            }
                        }
                    }
                    // Fin de la pièce, on passe à la suivante (ou au trésor à la fin de la boucle)
                    if (hero.enVie()) {
                        // Sortie des salles, la partie est finie
                        System.out.println("\n----------------------");
                        System.out.println("Bravo " + hero.obtenirNomHero() + " tu es arrivé dans la dernière pièce du donjon.");
                        PotionDeVie potionVie = new PotionDeVie(VALEURPOTIONVIE);
                        potionVie.appliquerEffet(hero);
                        hero.augmenterScore(1);
                        System.out.println("Tu as terminé " + hero.obtenirScore() + " donjons !");
                        /*
                           Menu pour sauvegarder la partie
                           Les données du héro sont récupérées puis sauvegarder
                        */
                        System.out.println("\n----------------------");
                        System.out.println("Veux tu sauvegarder ta progression avant le prohcain donjon ?");
                        System.out.println("*** CHOISIS ***");
                        System.out.println("1. Oui, je veux sauvegarder et faire une pause ici");
                        System.out.println("2. Non, je veux foncer dans le prochain donjon");
                        int choixSauvegarde = scannerMenu.nextInt();
                        if (choixSauvegarde == 1) {
                            Sauvegarde.sauvegarder(hero.obtenirNomHero(),
                                    hero.obtenirPointDeVie(),
                                    hero.obtenirPointDeVieInitial(),
                                    hero.obtenirForce(),
                                    hero.obtenirScore());
                        }
                    } else {
                        /*
                            Le hero a perdu la partie
                            On lui redonne ses points de vie initiaux pour la prochaine partie
                            On remet le booléen enVie à la valeur true
                            On remet aux valeurs initiales les valeurs de vie et de forces qui ont été augmentées par les potions
                         */
                        hero.gainPointDeVie(hero.obtenirPointDeVieInitial());
                        hero.modifierPointDeVieInitial(VALEURVIEHEROINITIAL);
                        hero.modifierForce(VALEURFORCEHEROINITIAL);
                        hero.modifierStatusVie();
                    }
                    System.out.println("\n----------------------");
                    System.out.println("Tu as gagné cette partie mais oseras tu affronter un autre donjon ?\n");
                }
            }while(choixMenu < 1 || choixMenu> 2);
        }
    }
}