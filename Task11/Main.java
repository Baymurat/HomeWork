import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Main class.
 */
public class Main {
    /**
     * Main method.
     *
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        /**
         * Instance of class FileWorker.
         */
        FileWorker fileWorker = new FileWorker();
        /**
         * Read file
         * @see FileWorker#read()
         */
        String tempString = fileWorker.read();

        /**
         * Instance of class Track
         */
        Track track = new Track();
        /**
         * Determines all points.
         * @see Track#determinePoints(String)
         */
        track.determinePoints(tempString);
        /**
         * Length of all way.
         * @see Track#lengthOfTrack
         */
        double lengthOfTrack = track.getLengthOfTrack();

        ArrayList<CostOfJourney> listOfTypes = listOfTypes();
        for (CostOfJourney c : listOfTypes) {
            print(c, lengthOfTrack);
        }
    }

    /**
     * Method prints some values of class.
     *
     * @param c
     * @param lengthOfTrack - length of all way.
     */
    private static void print(CostOfJourney c, double lengthOfTrack) {
        System.out.println(c.getName() + "   " + c.cost(lengthOfTrack) + "   " + c.puassTime(lengthOfTrack));
    }

    /**
     * Method builds list of classes, implements interface CostOfJourney.
     *
     * @return list - list of classes.
     */
    private static ArrayList<CostOfJourney> listOfTypes() {
        ArrayList<CostOfJourney> list = new ArrayList<>();
        list.add(new Bus());
        list.add(new Car());
        list.add(new Bycicle());
        list.add(new Walking());
        return list;
    }
}
