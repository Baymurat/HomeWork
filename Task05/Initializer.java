package Task05;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Admin on 20.10.2016.
 */
public class Initializer {
    public double initVariable() {
        double a = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                a = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Try again");
            }
            break;
        }
        return a;
    }
}
