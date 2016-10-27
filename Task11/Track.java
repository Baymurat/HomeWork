import java.util.ArrayList;

/**
 * Class determines all points from file and length of all way.
 */
public class Track {
    /**
     * Length of all way.
     */
    private double lengthOfTrack;
    /**
     * Field contains values of points.
     * First case of double[] will contain 'x', second case 'y'.
     */
    private ArrayList<double[]> listOfPoints = new ArrayList<>();

    /**
     * Method write to listOfPoints values of points from specified string.
     *
     * @param tempString - specified string, consists values of points.
     */
    public void determinePoints(String tempString) {
        /**
         * Temporary field.
         */
        String[] tempArray = tempString.split(" ");

        boolean b = true;
        /**
         * Temporary array will get values and will be written to listOfPoints.
         */
        double[] arrayForList = new double[2];
        /**
         * Procedure filling listOfPoints.
         */
        for (String s : tempArray) {
            /**
             * If true write to first case of arrayForList ('x').
             * Else write to second case ('y').
             */
            if (b) {
                /**
                 * Try parse double.
                 * Otherwise do nothing.
                 */
                try {
                    arrayForList = new double[2];
                    arrayForList[0] = Double.parseDouble(s);
                    b = false;
                } catch (NumberFormatException e) {
                }
            } else {
                /**
                 * Try parse double.
                 * Otherwise do nothing.
                 */
                try {
                    arrayForList[1] = Double.parseDouble(s);
                    listOfPoints.add(arrayForList);
                    b = true;
                } catch (NumberFormatException e) {
                }
            }
        }
    }

    /**
     * Method pass through listOfPoints and sum length between each points.
     *
     * @return lengthOfTrack - length of all way.
     */
    public double getLengthOfTrack() {
        for (int i = 0; i < listOfPoints.size() - 1; i++) {
            double x1 = listOfPoints.get(i)[0];
            double y1 = listOfPoints.get(i)[1];
            double x2 = listOfPoints.get(i + 1)[0];
            double y2 = listOfPoints.get(i + 1)[1];
            lengthOfTrack += distanceBetweenPoints(x1, x2) + distanceBetweenPoints(y1, y2);
        }
        return lengthOfTrack;
    }

    /**
     * @param a - values of first point.
     * @param b - values of second point.
     * @return length between points.
     */
    private double distanceBetweenPoints(double a, double b) {
        return Math.sqrt(Math.pow(b - a, 2));
    }
}

