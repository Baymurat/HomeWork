package drugoyTEST;

/**
 * Abstract class
 */
public abstract class ReadFrom {
    /**
     * Field stores set of IP.
     */
    protected String[] tempData;

    /**
     * Method creates and return field, stores set of IP and response value.
     *
     * @return String[][] generalData - need for html table.
     */
    protected String[][] getGeneralData() {
        String[][] generalData = new String[3][tempData.length];

        /**
         * In loop enter values of IP and their response values.
         */
        for (int i = 0; i < tempData.length; i++) {
            generalData[0][i] = tempData[i];
            generalData[1][i] = "" + (int) (Math.random() * 500);
            generalData[2][i] = "";
        }

        /**
         * In loop searching for max value of response.
         */
        int max = 0;
        for (int i = 0; i < generalData[0].length; i++) {
            int temp = Integer.valueOf(generalData[1][i]);
            if (temp > max) {
                max = temp;
            }
        }

        /**
         * Loop marks lines with max response values.
         * Need for multicolored html table.
         */
        for (int i = 0; i < generalData[0].length; i++) {
            int temp = Integer.valueOf(generalData[1][i]);
            if (temp == max) {
                generalData[2][i] = "max";
            }
        }
        return generalData;
    }
}
