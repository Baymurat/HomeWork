import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test for class Bus.
 */
public class TrackTest {
    Track track = new Track();

    @DataProvider(name = "data")
    public Object[][] getPoints() {
        return new Object[][]{
                {141.42, "az 0 0 100 100"},
                {2, "-1 dsa 1 1 1"},
                {2, "1 1 ds 1 -1"},
                {2, "1 -1 ds -1 -1"},
                {141.42, "0 0 20 20 20 20 80 80"}
        };
    }

    @Test(dataProvider = "data")
    public void testGetLengthOfTrack(double expected, String points) {
        track.determinePoints(points);
        assertEquals(track.getLengthOfTrack(), expected, 0.01);
    }

    @Test
    public void testDeterminePoints() throws Exception {
        track.determinePoints("qw er ty ui o1 23 45 67 89");
        assertFalse(track.listOfPoints.isEmpty());

        for (double[] arrayDouble : track.listOfPoints) {
            for (double d : arrayDouble) {
                assertNotNull(d);
                assertFalse(Double.isInfinite(d));
                assertFalse(Double.isNaN(d));
            }
        }
    }

    @Test
    public void testNotNegativeGetLengthOfTrack() throws Exception {
        assertTrue(track.getLengthOfTrack() >= 0);
    }

    @Test
    public void testNotNullGetLengthOfTrack() throws Exception {
        assertNotNull(track.getLengthOfTrack());
    }
}