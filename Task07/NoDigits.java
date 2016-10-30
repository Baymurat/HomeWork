package test;

/**
 * Class contains method, which checks if there is no digits
 * Extends class Primary.
 */
public class NoDigits extends Primary {
    /**Variable stores digits*/
    private String digits = "0123456789";

    /**Constructor call super*/
    NoDigits(String str) {
        super(str);
    }

    /**
     * Method return true if there no any digits.
     * Otherwise assign 'b' false and break.
     */
    @Override
    public boolean checkMethod() {
        boolean b = true;
        for (int i = 0; i < str.length(); i++) {
            if (digits.contains(str.charAt(i) + "")) {
                b = false;
                break;
            }
        }

        System.out.print("No digits: ");
        return b;
    }
}
