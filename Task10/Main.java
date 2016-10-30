package drugoyTEST;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class. Consist main method.
 */
public class Main {
    /**
     * Main method.Point of entry.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String args[]) throws IOException {
        /**
         * @see Main#chooseMode()
         */
        String mode = chooseMode();

        /**
         * Field stores all need data for html table.
         */
        String[][] dataForTab;

        if (mode.equals("command line")) {
            ReadFromCommandLine fromCommandLine = new ReadFromCommandLine(args);
            /**
             * @see ReadFrom#getGeneralData()
             */
            dataForTab = fromCommandLine.getGeneralData();
        } else {
            ReadFromFile fromFile = new ReadFromFile();
            /**
             * @see ReadFrom#getGeneralData()
             */
            dataForTab = fromFile.getGeneralData();
        }

        EntrailsOfHtml creator = new EntrailsOfHtml(dataForTab);
        /**
         * Field stores needed strings for html file.
         * @see EntrailsOfHtml#generator()
         */
        String forHtml = creator.generator();

        /**
         * Creating html file in needed path.
         */
        String path = System.getProperty("user.dir") + "/CREATED.html";
        File f = new File(path);

        try {
            PrintWriter out = new PrintWriter(f.getAbsoluteFile());

            try {
                out.print(forHtml);
            }
            finally {
                out.close();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method for choosing mode.
     * @return String string - mode.
     */
    public static String chooseMode() {
        System.out.println("Type \"command line\" or \"from file\"");
        Scanner scanner = new Scanner(System.in);
        String string;
        while (true) {
            string = scanner.nextLine().toLowerCase();
            if (string.equals("command line") || string.equals("from file")) break;
            System.out.println("Unclear, try again");
        }
        return string;
    }
}

