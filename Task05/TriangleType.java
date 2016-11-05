package Task05;

/**
 * Created by Admin on 20.10.2016.
 */
public class TriangleType {
    private double a, b, c;
    TriangleType(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void type() {
        /**
         * There is no loop, but it's easy way to choose one of cases of triangle, instead
         * using if...else multi branching.
         * Search moves from the particular to the general.
         */
        while (true) {
            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("There is no such triangle");
                break;
            }

            if (0 == Double.compare(a, b) && 0 == Double.compare(c, b)) {
                System.out.println("Equilateral");
                break;
            }

            if (0 == Double.compare(a, b) || 0 == Double.compare(c, b) || 0 == Double.compare(c, a)) {
                System.out.println("Isosceles");
                break;
            }

            System.out.println("Regular");
            break;
        }
    }
}
