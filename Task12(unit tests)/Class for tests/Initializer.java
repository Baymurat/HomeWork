package Task05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class is used for input variables in double type values.
 */
public class Initializer {
    /**
     * Method read data from keyboard and write to variable.
     *
     * @return double a - inputted variable.
     * @throws IOException - default exception in BufferedReader case.
     */
    public double initVariable() throws IOException {
        double a;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        /**
         * Loop finish if enter valid value.
         * Otherwise it can repeats many times.
         */
        while (true) {
            try {
                System.out.print("Enter side: ");
                String temp = reader.readLine();
                a = Double.valueOf(temp);
            } catch (NumberFormatException e) {
                System.out.println("Not a number. Try again");
                continue;
            }
            break;
        }
        return a;
    }
}
