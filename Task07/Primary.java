package test;

/**
 * Class, which inherited the rest
 */
public abstract class Primary {
    /**Variable stores value of inserted string to descendants*/
    protected String str = "";

    /**
     * Rewrite only 0-9, a-z, A-Z characters.
     * Ignore any other symbols.
     */
    Primary(String str) {
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);

            /**Save separating punctuation*/
            if (c == ' ' || c == ',' || c == '.') {
                this.str += c;
                continue;
            }

            /**Searching from '0' to 'z' and passing by some symbols*/
            for (char i = '0'; i <= 'z'; i++) {
                /**Symbols which passing by*/
                if (i == ':') {
                    i += 7;
                    continue;
                }

                /**Symbols which passing by*/
                if (i == '[') {
                    i += 5;
                    continue;
                }

                /**Add to this.str if match is found*/
                if (c == i) {
                    this.str += c;
                    break;
                }
            }
        }
    }

    /**Method will implement in descendants*/
    abstract protected boolean checkMethod();
}
