/**
 * Class Bus implements interface CostOfJourney.
 */
public class Bus implements CostOfJourney {
    /**
     * Private and final fields of class
     */
    private final double SPEED = 60;
    private final int PASSENGER_COUNT = 30;
    private final double PAYMENT_FOR_TRAVEL = 100;
    private double passegersPay = PASSENGER_COUNT * PAYMENT_FOR_TRAVEL;
    private final int FUEL_CONSUMPTION = 35;
    private final double FUEL_COST = 0.6;
    private String name = "Bus";

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
        return ((lengthOfTrack / 100) * FUEL_CONSUMPTION * FUEL_COST) - passegersPay;
    }
}
