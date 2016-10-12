package test.HW8;

/**
 * Class contains method for calculating average price of products.
 */
public class AveragePrice extends PrimaryCommandClass {
    /**
     * Method calculates average price of products
     *
     * @param command string of command.
     * @param cd      data stores object.
     * @see PrimaryCommandClass#commandName(String, CreateData)
     */
    @Override
    public void commandName(String command, CreateData cd) {
        /**
         * Convert to lower case to avoid problems with different registers.
         */
        command = command.toLowerCase();
        if (command.equals("average price")) {
            int n1 = cd.listOfEntity.get(0).get(0).getCountOfAllSubjects();
            double n2 = cd.listOfEntity.get(0).get(0).getPriceOfAllSubjects();
            System.out.println("Average price: " + n2 / n1);
        }
    }
}
