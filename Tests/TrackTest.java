import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for class Bus.
 */
public class TrackTest {
    Track track = new Track();

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
    public void testGetLengthOfTrack() throws Exception {
        assertNotNull(track.getLengthOfTrack());
        assertTrue(track.getLengthOfTrack() >= 0);
        assertFalse(Double.isInfinite(track.getLengthOfTrack()));
        assertFalse(Double.isNaN(track.getLengthOfTrack()));
    }
}