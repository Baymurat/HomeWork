package drugoyTEST;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class need for file mode reading.
 */
public class ReadFromFile extends ReadFrom {
    /**
     * Field stores strings from file.
     * Will be splitted.
     */
    private String stringFromFile;

    /**
     * Path to file.
     */
    private String path;

    ReadFromFile() {
        System.out.println("Show full path: ");
        Scanner scanner = new Scanner(System.in);
        path = scanner.nextLine();
        scanner.close();
        try {
            FileWorker fileWorker = new FileWorker();
            /**
             * @see FileWorker#reader(String)
             */
            stringFromFile = fileWorker.reader(path);
        }
        catch (IOException e) {
            System.out.println("Error path");
        }
        stringFromFile = stringFromFile.replace('\n', ' ');
        this.tempData = stringFromFile.split(" ");

    }
}
