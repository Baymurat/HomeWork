package test.HW8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class InputData {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Method for initializing string fields.
     *
     * @return String
     * @throws IOException
     */
    public String inputString() throws IOException {
        String string;
        while (true) {
            string = reader.readLine();
            if (string.isEmpty()) {
                System.out.println("This field can't be an empty");
                continue;
            }
            break;
        }
        return string;
    }

    /**
     * Method for initializing number fields.
     *
     * @return Number.
     * @throws IOException
     */
    public int inputNumber() throws IOException {
        int number;
        String string;
        while (true) {
            string = reader.readLine();
            if (string.isEmpty()) {
                System.out.println("This field can't be an empty");
                continue;
            }

            try {
                number = Integer.parseInt(string);
            } catch (NumberFormatException e) {
                System.out.println("This field can't be a string.");
                continue;
            }
            break;
        }
        return number;
    }

    /**
     * Method for exit the loop.
     *
     * @return True or false
     * @throws IOException
     */
    public boolean inputForExit() throws IOException {
        String string;
        boolean b;
        while (true) {
            string = reader.readLine();
            if (string.equals("No")) {
                b = true;
                break;
            }
            if (string.equals("Yes")) {
                b = false;
                break;
            }
            System.out.println("Unclear");
        }
        return b;
    }
}
