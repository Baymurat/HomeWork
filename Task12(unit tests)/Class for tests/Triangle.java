package Task05;

import java.math.BigDecimal;

/**
 * Class consists sides of triangle, method checks if valid values
 * and method determines type of triangle.
 */
public class Triangle {

    private BigDecimal a, b, c;

    public Triangle(double a, double b, double c) throws Exception {
        isValidNumber(a);
        isValidNumber(b);
        isValidNumber(c);
        this.a = BigDecimal.valueOf(a);
        this.b = BigDecimal.valueOf(b);
        this.c = BigDecimal.valueOf(c);
    }

    /**
     * Method determines if variable has valid value.
     *
     * @param a - variable for checking.
     * @throws Exception - if value is NaN or Infinite.
     */
    public void isValidNumber(double a) throws Exception {
        if (Double.isInfinite(a) || Double.isNaN(a)) {
            throw new Exception("No valid number");
        }
    }

    /**
     * Method determines type of triangle.
     *
     * @return String type - type of triangle.
     */
    public String type() {
        String type;
        /**
         * There is no loop, but it's easy way to choose one of cases of triangle, instead
         * using if...else multi branching.
         * Search moves from the particular to the general cases.
         */
        while (true) {
            if (a.compareTo(b.add(c)) >= 0 || b.compareTo(a.add(c)) >= 0 || c.compareTo(b.add(a)) >= 0) {
                type = "There is no such triangle";
                break;
            }

            if (0 == a.compareTo(b) && 0 == a.compareTo(c)) {
                type = "Equilateral";
                break;
            }

            if (0 == a.compareTo(b) || 0 == a.compareTo(c) || 0 == c.compareTo(b)) {
                type = "Isosceles";
                break;
            }

            type = "Regular";
            break;
        }
        return type;
    }
}
