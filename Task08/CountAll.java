package test.HW8;

/**
 * Class contains method displays static field countOfAllSubjects of class SomeSubject.
 * To which access can be obtained from any objects.
 */
public class CountAll extends PrimaryCommandClass {
    /**
     * @param command string of command.
     * @param cd      data stores object.
     * @see PrimaryCommandClass#commandName(String, CreateData)
     */
    public void commandName(String command, CreateData cd) {
        /**
         * Convert to lower case to avoid problems with different registers.
         */
        command = command.toLowerCase();
        if (command.equals("count all")) {
            System.out.println("Count all: " + cd.listOfEntity.get(0).get(0).getCountOfAllSubjects());
        }
    }
}
