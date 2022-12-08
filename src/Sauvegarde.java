
import java.io.*;

public class Sauvegarde {
    // Obtenir le chemim où se trouve le fichier
    public static String filePath = new File("").getAbsolutePath();

    public static String charger() throws FileNotFoundException {

        // Création d’un fileReader pour lire le fichier
        FileReader fileReader = new FileReader(filePath + "/src/sauvegarde.txt");

        // Création d’un bufferedReader qui utilise le fileReader
        BufferedReader lecture = new BufferedReader(fileReader);

        try {
            System.out.println("\n----------------------");
            System.out.println("Chargement en cours");
            String ligne = lecture.readLine();
            return ligne;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sauvegarder(String nomHero, int nombrePointDeVie, int nombrePointDeVieInitial, int forceHero, int score) throws IOException {

        // Création d’un fileReader pour lire le fichier
        FileWriter fileWriter = new FileWriter(filePath + "/src/sauvegarde.txt");

        // Création d’un bufferedReader qui utilise le fileReader
        BufferedWriter ecriture = new BufferedWriter(fileWriter);
        System.out.println("Ta partie a été sauvegardée");
        String chaineAEnregistrer = nomHero + ", "
                + Integer.toString(nombrePointDeVie) + ", "
                + Integer.toString(nombrePointDeVieInitial) + ", "
                + Integer.toString(forceHero) + ", "
                + Integer.toString(score);
        ecriture.write(chaineAEnregistrer);
        ecriture.close();
    }
}