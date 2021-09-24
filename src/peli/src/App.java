import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class App {
    static String folder = "Content";
    public static void main(String[] args) throws Exception {

        File[] menuFiles = getTextFilesInFolder();
        printMenus(menuFiles);

        // Tässä ohjelma voi kysyä mihin menuun mennään..
        // ja sen jälkeen toistaa samat asiat..
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
        }
    }
    
    static File[] getTextFilesInFolder() {
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                // We want to find only .c files
                return name.endsWith(".txt");
            }
        };
        
        File[] files = new File(folder).listFiles(filter);
        return files;
    }
}
