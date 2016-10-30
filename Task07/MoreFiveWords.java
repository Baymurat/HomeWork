package test;

/**
 * Class contains method, which checks if there is more than five words.
 * Extends class Primary.
 */
public class MoreFiveWords extends Primary {
    /**Constructor call super*/
    MoreFiveWords(String str) {
        super(str);
    }

    /**
     * Method return true if there is more than five words.
     * Separating symbols '.' and ',' replace with space.
     * In order that in the end string will be splited by space.
     */
    @Override
    public boolean checkMethod() {
        /**Replace (rewrite) '.' with space*/
        String[] strings = str.split("[.]");
        str = "";
        for (String s : strings) {
            str += s + " ";
        }

        /**Replace (rewrite) ',' with space*/
        strings = str.split(",");
        str = "";
        for (String s : strings) {
            str += s + " ";
        }

        /**Split by space*/
        strings = str.split(" ");

        /**
         * There's a possibility of many empty cases.
         * Count no empty cases, skipping empty.
         */
        int length = 0;
        for (String s : strings) {
            if (s.isEmpty()) continue;
            length++;
        }

        System.out.print("More than five words: ");
        return length > 5;
    }
}
