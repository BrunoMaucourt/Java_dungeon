
import java.io.*;

public class Sauvegarde {
    // Obtenir le chemim où se trouve le fichier
    public static String filePath = new File("").getAbsolutePath();

    public static void charger() throws FileNotFoundException {

        // Création d’un fileReader pour lire le fichier
        FileReader fileReader = new FileReader(filePath + "/src/sauvegarde.txt");

        // Création d’un bufferedReader qui utilise le fileReader
        BufferedReader lecture = new BufferedReader(fileReader);

        String ligne;

        try {
            ligne = lecture.readLine();
            while (ligne != null) {

                // affichage de la ligne
                System.out.println(ligne);

                // lecture de la prochaine ligne
                ligne = lecture.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sauvegarder() throws IOException {

        // Création d’un fileReader pour lire le fichier
        FileWriter fileWriter = new FileWriter(filePath + "/src/sauvegarde.txt");

        // Création d’un bufferedReader qui utilise le fileReader
        BufferedWriter ecriture = new BufferedWriter(fileWriter);

        ecriture.write("test");
        ecriture.newLine();
        ecriture.write("Gateaux");
        ecriture.close();
    }

    public void enregistrerDonnees(){

    }
}