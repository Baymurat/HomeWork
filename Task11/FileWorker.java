import java.io.*;
import java.util.Scanner;

/**
 * Class for working with file.
 */
public class FileWorker {
    /**
     * Method read and write to String field, specified file.
     *
     * @return string of written file.
     * @throws FileNotFoundException
     */
    public String read() throws FileNotFoundException {
        System.out.print("Enter file path: ");
        Scanner scanner = new Scanner(System.in);
        /**
         * Path of specified file.
         */
        String filePath = scanner.nextLine();

        /**
         * Field will contain string of file.
         */
        StringBuilder sb = new StringBuilder();

        /**
         * If wrong path throw exception.
         */
        exists(filePath);
        File file = new File(filePath);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));

            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append(" ");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

    /**
     * Method check if exist file in shown path.
     *
     * @param filePath - path of file.
     * @throws FileNotFoundException
     */
    private void exists(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
}
