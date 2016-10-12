package test.HW8;

import java.util.ArrayList;

/**
 * Created by Ольга on 11.10.16.
 */
public class AveragePriceOfType extends PrimaryCommandClass {
    /**
     * @param command string of command.
     * @param cd      data stores object.
     * @see PrimaryCommandClass#commandName(String, CreateData)
     */
    @Override
    protected void commandName(String command, CreateData cd) {
        double avPrice = 0;
        /**
         * Convert to lower case to avoid problems with different registers.
         */
        command = command.toLowerCase();
        String[] sLine = command.split(" ");
        if (command.contains("average price") && sLine.length > 2) {
            for (ArrayList<SomeSubject> se : cd.listOfEntity) {
                /**
                 * Name of type came with a command on third place.
                 * Compare the first element of list of lists.
                 * If match is found sum fields (priceOfSubject) of line.
                 * And divide to size-1 of line, which means countOfSubjects.
                 */
                if (se.get(0).getTypeOfEntity().toLowerCase().equals(sLine[2].toLowerCase())) {
                    for (int i = 1; i < se.size(); i++) {
                        avPrice += se.get(i).getPriceOfSubject();
                    }
                    avPrice = avPrice / (se.size() - 1);
                    System.out.println("Averge price of typr: " + avPrice);
                    break;
                }
            }
        }
    }
}
