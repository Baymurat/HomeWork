import Task05.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test triangle.
 */
public class TriangleTest {
    private final String EQUILATERAL = "Equilateral";
    private final String ISOSCELES = "Isosceles";
    private final String REGULAR = "Regular";
    private final String NO_TRIANGLE = "There is no such triangle";

    Triangle triangle;

    @DataProvider(name = "negative data with exception")
    public Object[][] getNegativeExceptionsData() {
        return new Object[][]{
                {Double.NaN, Double.NaN, Double.NaN},
                {Double.NaN, Double.NaN, 0.0},
                {Double.NaN, -5.0, 0.0},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0.0},
                {Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY},
                {Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0.0},
        };
    }

    @DataProvider(name = "negative data invalid values")
    public Object[][] getNegativeInvalidData() {
        return new Object[][]{
                {1.0, 2.0, 3.0, NO_TRIANGLE},
                {50.0, 50.0, 0.0, NO_TRIANGLE},
                {0.0, 0.0, 0.0, NO_TRIANGLE},
                {-3.0, -4.0, -5.0, NO_TRIANGLE},
                {-3.0, -4.0, 5.0, NO_TRIANGLE},
                {-3.0, 4.0, 5.0, NO_TRIANGLE},
        };
    }

    @DataProvider(name = "positive data")
    public Object[][] getPositiveData() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, EQUILATERAL},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, ISOSCELES},
                {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, EQUILATERAL},
                {Double.MAX_VALUE, Double.MAX_VALUE, 1.0, ISOSCELES},
                {3.0, 4.0, 5.0, REGULAR},
                {100.0, 100.0, 100.0, EQUILATERAL},
                {500.0, 500.0, 0.00000001, ISOSCELES}
        };
    }

    @Test(dataProvider = "negative data with exception", expectedExceptions = Exception.class)
    public void testNegativeType(double a, double b, double c) throws Exception {
        triangle = new Triangle(a, b, c);
    }

    @Test(dataProvider = "negative data invalid values")
    public void testNegativeInvalidValues(double a, double b, double c, String expected) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.type(), expected);
    }

    @Test(dataProvider = "positive data")
    public void testPositiveType(double a, double b, double c, String expected) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.type(), expected);
    }
}