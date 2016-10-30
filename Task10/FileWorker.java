package drugoyTEST;

import java.io.*;

/**
 * Class implements method for working with file.
 */
public class FileWorker {
    /**
     * @param filePath - path to file.
     * @return strings of file.
     * @throws IOException
     */
    public String reader(String filePath) throws IOException {
        BufferedReader in = null;
        /**
         * Field will collect all strings from file.
         */
        StringBuilder sb = new StringBuilder();
        try {
            in = new BufferedReader(new FileReader(filePath));
            String c;
            while ((c = in.readLine()) != null) {
                sb.append(c);
                sb.append("\n");
            }
        }
        finally {
            if (in != null)
                in.close();
        }
        return sb.toString();
    }
}

