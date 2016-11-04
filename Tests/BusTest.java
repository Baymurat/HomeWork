import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for class Bus.
 */
public class BusTest {
    Bus bus = new Bus();
    @Test
    public void testPassTime() {
        assertTrue(bus.passTime(0) >= 0);
        assertNotNull(bus.passTime(Double.MAX_VALUE));
        assertNotNull(bus.passTime(Double.MIN_VALUE));
        assertFalse(Double.isInfinite(bus.passTime(0)));
        assertFalse(Double.isNaN(bus.passTime(0)));
    }

    @Test
    public void testCost() {
        assertTrue(bus.passTime(0) >= 0);
        assertNotNull(bus.cost(Double.MAX_VALUE));
        assertNotNull(bus.cost(Double.MIN_VALUE));
        assertFalse(Double.isInfinite(bus.cost(0)));
        assertFalse(Double.isNaN(bus.cost(0)));
    }
}