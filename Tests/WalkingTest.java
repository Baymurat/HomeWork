import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for class Bus.
 */
public class WalkingTest {
    Walking walking = new Walking();

    @Test
    public void testPassTime() throws Exception {
        assertTrue(walking.passTime(0) >= 0);
        assertNotNull(walking.passTime(Double.MAX_VALUE));
        assertNotNull(walking.passTime(Double.MIN_VALUE));
        assertFalse(Double.isInfinite(walking.passTime(0)));
        assertFalse(Double.isNaN(walking.passTime(0)));
    }

    @Test
    public void cost() throws Exception {
        assertTrue(walking.cost(0) >= 0);
        assertNotNull(walking.cost(Double.MAX_VALUE));
        assertNotNull(walking.cost(Double.MIN_VALUE));
        assertFalse(Double.isInfinite(walking.cost(0)));
        assertFalse(Double.isNaN(walking.cost(0)));
    }
}