package test.HW8;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class creates list of products
 */
public class CreateData {
    ArrayList<ArrayList<SomeSubject>> listOfEntity = new ArrayList<>();
    InputData input = new InputData();

    /**
     * Method create list of lists.
     * The first element of any list is the TYPE of product.
     * The user chooses to expand list or not (Yes or Not)
     *
     * @throws IOException
     */
    public void createData() throws IOException {
        while (true) {
            ArrayList<SomeSubject> list = new ArrayList<>();

            System.out.print("Enter type of product: ");
            String string = input.inputString();
            list.add(new SomeSubject(string));

            while (true) {
                System.out.print("Enter name of product: ");
                String name = input.inputString();

                System.out.print("Enter count of product: ");
                int count = input.inputNumber();

                System.out.print("Enter price of product: ");
                int price = input.inputNumber();

                list.add(new SomeSubject(name, count, price));

                System.out.println("More PRODUCT? Yes or No");
                if (input.inputForExit()) break;
            }
            listOfEntity.add(list);

            System.out.println("More TYPE? Yes or No");
            if (input.inputForExit()) break;
        }
    }
}
