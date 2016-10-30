/**
 * Class Walking implements interface CostOfJourney.
 */
public class Walking implements CostOfJourney {
    private final double SPEED = 5;
    private final int PASSENGER_COUNT = 1;
    private String name = "Walking";

    /**
     * Method returns kind of move.
     *
     * @return name - kind of move.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Method returns time spent for overcome all way.
     *
     * @param lengthOfTrack - length of all way.
     * @return time spent for overcome all way.
     */
    @Override
    public double puassTime(double lengthOfTrack) {
        return lengthOfTrack / SPEED;
    }

    /**
     * Method returns cost spent for overcome all way.
     *
     * @param lengthOfTrack - length of all way.
     * @return cost spent for overcome all way.
     */
    @Override
    public double cost(double lengthOfTrack) {
        return 0;
    }
}
