package drugoyTEST;

import java.io.*;

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
        EntrailsOfHtml creator = new EntrailsOfHtml();
        /**
         * Field stores needed strings for html file.
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
}

