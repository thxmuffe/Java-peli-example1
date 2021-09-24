import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class App {
    static String folder = "src/peli/Content";
    public static void main(String[] args) throws Exception {

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        File[] menuFiles = getTextFilesInFolder(folder);
        printMenus(menuFiles);

        Scanner lukija = new Scanner(System.in);

        // Käyttäjä valitsee mihin ala-valikkoon haluaa
        // valinta pitää vastata kansion nimeä nykyisessä kansiossa.
        String kansio = lukija.nextLine();

        // Kun käyttäjä on valinnut kansion, listataan sen sisällä olevat vaihtoehdot
        File[] subMenu = getTextFilesInFolder(folder + "/" + kansio);
        printMenus(subMenu);
        
    }

    static void printMenus(File[] files) {
        for (File file : files) {
            try (Scanner tiedostonLukija = new Scanner(file)) {
                // System.out.println("File: " + file.getName() + " sisältö:");
                while (tiedostonLukija.hasNextLine()) {
                    System.out.println(tiedostonLukija.nextLine());
                }
            } catch (Exception e) {
                System.out.println("Tuli virhe: " + e.getLocalizedMessage());
            }

            System.out.println(); // Halutaan tyhjä rivi menujen väliin
        }
    }
    
    static File[] getTextFilesInFolder(String path) {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                // We want to find only .c files
                return name.endsWith(".txt");
            }
        };
        
        File[] files = new File(path).listFiles(filter);
        return files;
    }
}
