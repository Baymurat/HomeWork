/**
 * Class Car implements interface CostOfJourney.
 */
public class Car implements CostOfJourney {
    /**
     * Private and final fields of class.
     */
    private final double SPEED = 90;
    private final int FUEL_CONSUMPTION = 10;
    private final double FUEL_COST = 0.6;
    private String name = "Car";

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
        return lengthOfTrack/SPEED;
    }

    /**
     * Method returns cost spent for overcome all way.
     *
     * @param lengthOfTrack - length of all way.
     * @return cost spent for overcome all way.
     */
    @Override
    public double cost(double lengthOfTrack) {
        return (lengthOfTrack/100) * FUEL_CONSUMPTION * FUEL_COST;
    }
}
