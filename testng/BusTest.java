import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


/**
 * Test for class Bus.
 */
public class BusTest {
    Bus bus = new Bus();

    @DataProvider(name = "for bus")
    public Object[][] data() {
        return new Object[][]{
                {1.0, 60.0},
                {2.0, 120.0},
                {3.0, 180.0},
                {2.0, 120.0},
                {4.0, 240.0}
        };
    }

    @Test(dataProvider = "for bus")
    public void testPoitivePassTime(double expected, double a) {
        assertEquals(bus.passTime(a), expected);
    }

    @Test
    public void testNotNegativePassTime() {
        assertTrue(bus.passTime(0) >= 0);
    }

    @Test
    public void testNotNullPassTime() {
        assertNotNull(bus.passTime(Double.MAX_VALUE));
        assertNotNull(bus.passTime(Double.MIN_VALUE));
    }

    @Test
    public void testNotNegativeCost() {
        assertTrue(bus.passTime(0) >= 0);
    }

    @Test
    public void testNotNullCost() {
        assertNotNull(bus.cost(Double.MAX_VALUE));
        assertNotNull(bus.cost(Double.MIN_VALUE));
    }
}