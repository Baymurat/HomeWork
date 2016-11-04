import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test for class Bus.
 */
public class WalkingTest {
    Walking walking = new Walking();

    @DataProvider(name = "for walking")
    public Object[][] data() {
        return new Object[][]{
                {1.0, 5.0},
                {2.0, 10.0},
                {3.0, 15.0},
                {2.0, 10.0},
                {4.0, 20.0}
        };
    }

    @Test(dataProvider = "for walking")
    public void testPoitivePassTime(double expected, double a) {
        assertEquals(walking.passTime(a), expected);
    }

    @Test
    public void testNotNegativePassTime() throws Exception {
        assertTrue(walking.passTime(0) >= 0);
    }

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(walking.passTime(Double.MAX_VALUE));
        assertNotNull(walking.passTime(Double.MIN_VALUE));
    }

    @Test
    public void testNotNegtiveCost() throws Exception {
        assertTrue(walking.cost(0) >= 0);
    }

    @Test
    public void testNotNullCost() {
        assertNotNull(walking.cost(Double.MAX_VALUE));
        assertNotNull(walking.cost(Double.MIN_VALUE));
    }
}