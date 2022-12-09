import java.io.*;

/**
 * Classe permettant de sauvegarder la partie mais aussi de la charger
 * La sauvegarde se fait dans un fichier appelés sauvegarde.txt
 */


public class Sauvegarde {
    /**
     * Obtenir le chemim où se trouve le fichier
     */
    public static String filePath = new File("").getAbsolutePath();

    /**
     * Charger les données sauvegardées
     * Envoie un message pour indiquer que le chargement a eu lieu
     * @return une ligne de chaine de caractère contenant les valeurs sauvegardées
     * @throws FileNotFoundException
     */
    public static String charger() throws FileNotFoundException {
        // Création d’un fileReader pour lire le fichier
        FileReader fileReader = new FileReader(filePath + "/src/sauvegarde.txt");
        // Création d’un bufferedReader qui utilise le fileReader
        BufferedReader lecture = new BufferedReader(fileReader);
        // Tester la lecture des données
        try {
            System.out.println("\n----------------------");
            System.out.println("Chargement en cours");
            String ligne = lecture.readLine();
            return ligne;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sauvegarder les données du joueur
     * Celles-ci serviront à modifier une instance de héro
     * Envoie un message pour indiquer que les données ont été sauvegardées
     * @param nomHero
     * @param nombrePointDeVie
     * @param nombrePointDeVieInitial
     * @param forceHero
     * @param score
     * @throws IOException
     */
    public static void sauvegarder(String nomHero, int nombrePointDeVie, int nombrePointDeVieInitial, int forceHero, int score) throws IOException {
        // Création d’un fileReader pour lire le fichier
        FileWriter fileWriter = new FileWriter(filePath + "/src/sauvegarde.txt");
        // Création d’un bufferedReader qui utilise le fileReader
        BufferedWriter ecriture = new BufferedWriter(fileWriter);
        System.out.println("Ta partie a été sauvegardée");
        /*
            Concatene dans une chaine de caractère les différentes informations
            Les valeurs numériques sont converties en chaine de caractères
         */
        String chaineAEnregistrer = nomHero + ", "
                + Integer.toString(nombrePointDeVie) + ", "
                + Integer.toString(nombrePointDeVieInitial) + ", "
                + Integer.toString(forceHero) + ", "
                + Integer.toString(score);
        ecriture.write(chaineAEnregistrer);
        // Permet de fermer le fichier pour finaliser la sauvegarde
        ecriture.close();
    }
}