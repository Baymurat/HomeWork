package drugoyTEST;

import java.io.*;

/**
 * Class collects pieces of the html file in String field.
 */
public class EntrailsOfHtml {
    String[][] dataForTab;

    EntrailsOfHtml(String[][] d) {
        this.dataForTab = d;
    }

    /**
     * First part of html file.
     */
    private String start = "<!DOCTYPE HTML>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>Dir property</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<table style=\"border:none;margin:0px\" >\n" +
            "    <tr align=\"center\" bgcolor=\"#CECFCE\" height=\"50\">\n" +
            "        <td width=\"300\"><b>Server</b></td>\n" +
            "        <td width=\"300\"><b>Response, ms</b></td>\n" +
            "    </tr>";

    /**
     * The last part of html file.
     */
    private String end = "</table>\n" +
            "</body>\n" +
            "</html>";

    /**
     * Fields need to create table in html file.
     * Beginning of row in table and end of row.
     */
    private String rowBegin = "<tr bgcolor=\"#EFEFEF\">";
    private String rowBegin2 = "<tr bgcolor=\"#F7F7F7\">";
    private String rowBegin3 = "<tr bgcolor=\"red\">";
    private String rowEnd = "</tr>";
    private String dataBegin = "<td>";
    private String dataEnd = "</td>";

    /**
     * Method collect together all parts of html file.
     *
     * @return String html - entrails of html file.
     * @throws IOException
     */
    public String generator() throws IOException {
        /**
         * Filed will collect entrails of html file.
         */
        String html = "";

        /**
         * Filed has been used for multicolored lines.
         */
        boolean b = true;

        /**
         * Start gathering.
         */
        html += start;

        /**
         * In loop getting properties for each file from array.
         */

        for (int j = 0; j < dataForTab[1].length; j++) {
            if (dataForTab[2][j].equals("max")) {
                html += rowBegin3;
            } else {
                /**
                 * Implementation of multicolored lines.
                 * Part 1.
                 */
                if (b) {
                    html += rowBegin;
                } else {
                    html += rowBegin2;
                }
            }

            html += dataBegin + dataForTab[0][j] + dataEnd;
            html += dataBegin + dataForTab[1][j] + dataEnd;

            /**
             * Implementation of multicolored lines.
             * Part 2.
             */
            b = !b;
            html += rowEnd;
        }

        /**
         * End gathering entrails of html file.
         */
        html += end;
        return html;
    }
}
