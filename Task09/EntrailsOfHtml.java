package drugoyTEST;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class collects pieces of the html file in String field.
 */
public class EntrailsOfHtml {
    /**
     * Field store a path.
     */
    String path = System.getProperty("user.dir");

    /**
     * Array of files from showed path.
     */
    File[] listOfFiles = new File(path).listFiles();

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
            "        <td width=\"150\"><b>ИМЯ</b></td>\n" +
            "        <td width=\"150\"><b>ТИП</b></td>\n" +
            "        <td width=\"150\"><b>ДАТА СОЗДАНИЯ</b></td>\n" +
            "        <td width=\"150\"><b>РАЗМЕР (в Kb)</b></td>\n" +
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
        for (File f : listOfFiles) {
            /**
             * Implementation of multicolored lines.
             * Part 1.
             */
            if (b) {
                html += rowBegin;
            } else {
                html += rowBegin2;
            }

            /**
             * Case for name.
             */
            html += dataBegin + f.getName() + dataEnd;

            /**
             * Case for type of file.
             */
            if (f.isFile()) {
                html += dataBegin + "FILE" + dataEnd;
            } else {
                html += dataBegin + "DIR" + dataEnd;
            }

            /**
             * Case for creation time.
             * @see EntrailsOfHtml#getCreationTime(File)
             */
            html += dataBegin + getCreationTime(f) + dataEnd;

            /**
             * Case for size.
             */
            html += dataBegin + f.length() + dataEnd;
            html += rowEnd;

            /**
             * Implementation of multicolored lines.
             * Part 2.
             */
            b = !b;
        }

        /**
         * End gathering entrails of html file.
         */
        html += end;
        return html;
    }

    /**
     * Method get creation time of file.
     *
     * @param f file - whose time will be gotten.
     * @return String date - formatted creation time of file.
     * @throws IOException
     */
    public String getCreationTime(File f) throws IOException {
        Path file = Paths.get(f.getAbsolutePath());
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

        /**
         * Type FileTime stores creation time of file in specific format.
         */
        FileTime fileTime = attr.creationTime();

        /**
         * Convert to Day.Month.Year format.
         */
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String date = df.format(fileTime.toMillis());
        return date;
    }
}
