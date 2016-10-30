package test;

/**
 * Class contains method, which checks if there is only digits
 * Extends class Primary.
 */
public class OnlyDigits extends Primary {
    /**Constructor call super*/
    OnlyDigits(String str) {
        super(str);
    }


    /** Method return true if there is only digits.*/
    @Override
    public boolean checkMethod() {
        boolean b = true;

        /**If a match is found assign 'b' false and break*/
        for (char i = 'A'; i <= 'z'; i++) {
            if (str.contains(i + "")) {
                b = false;
                break;
            }
        }

        System.out.print("Only digits: ");
        return b;
    }
}
