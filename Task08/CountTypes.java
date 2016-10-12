package test.HW8;

/**
 * Class contains method displays static field  countOfTypes of class SomeSubject.
 * To which access can be obtained from any objects.
 */
public class CountTypes extends PrimaryCommandClass {
    /**
     * @param command string of command.
     * @param cd      data stores object.
     * @see PrimaryCommandClass#commandName(String, CreateData)
     */
    @Override
    protected void commandName(String command, CreateData cd) {
        /**
         * Convert to lower case to avoid problems with different registers.
         */
        command = command.toLowerCase();
        if (command.equals("count types")) {
            System.out.println("Count types: " + cd.listOfEntity.get(0).get(0).getCountOfTypes());
        }
    }
}
