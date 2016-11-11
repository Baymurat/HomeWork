import Task05.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.*;

/**
 * Test triangle.
 */
public class TriangleTest {
    private final String filePath = "data_for_test.xml";
    /**
     * Names of tags which store data in attributes, in XML file.
     */
    private String tag1 = "withException";
    private String tag2 = "invalidValues";
    private String tag3 = "positives";

    Triangle triangle;

    /**
     * Took out in common this part.
     * For avoiding repeating calls.
     */
    File file = new File(filePath);
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(file);

    // Generating by default.
    public TriangleTest() throws IOException, SAXException, ParserConfigurationException {
    }

    /**
     * Method build and return Object[][] result.
     *
     * @param tagName - name of tag from XML, which attributes will be fetched.
     * @return Object[][] result - array of data from XML file.
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public Object[][] dataBuilder(String tagName) throws IOException, SAXException, ParserConfigurationException {
        Node node = document.getElementsByTagName(tagName).item(0);
        NodeList nodeList = node.getChildNodes();
        Object[][] result = new Object[nodeList.getLength()][];

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node tempNode = nodeList.item(i);
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) tempNode;
                /**
                 * @see TriangleTest#setDoubleValue(String) parsing to double value.
                 */
                result[i] = new Object[]{
                        setDoubleValue(element.getAttribute("sideA")),
                        setDoubleValue(element.getAttribute("sideB")),
                        setDoubleValue(element.getAttribute("sideC")),
                        element.getAttribute("expected")
                };
            }
        }

        return result;
    }

    /**
     * @see Element#getAttribute(String) - this method returns string value,
     * while in some case need double. As solution
     * use method parses string value to double.
     * @param attributeValue - value of attribute from XML file.
     * @return double value.
     */
    public double setDoubleValue(String attributeValue) {
        if (attributeValue.equals("Double.MAX_VALUE")) {
            return Double.MAX_VALUE;
        }

        if (attributeValue.equals("Double.MIN_VALUE")) {
            return Double.MIN_VALUE;
        }

        if (attributeValue.equals("Double.POSITIVE_INFINITY")) {
            return Double.POSITIVE_INFINITY;
        }

        if (attributeValue.equals("Double.NEGATIVE_INFINITY")) {
            return Double.NEGATIVE_INFINITY;
        }

        if (attributeValue.equals("Double.NaN")) {
            return Double.NaN;
        } else return Double.parseDouble(attributeValue);
    }

    @DataProvider(name = "negative data with exception")
    public Object[][] getNegativeExceptionData() throws ParserConfigurationException, SAXException, IOException {
        return dataBuilder(tag1);
    }

    @DataProvider(name = "negative data invalid values")
    public Object[][] getNegativeInvalidData() throws ParserConfigurationException, SAXException, IOException {
        return dataBuilder(tag2);
    }

    @DataProvider(name = "positive data")
    public Object[][] getPositiveData() throws ParserConfigurationException, SAXException, IOException {
        return dataBuilder(tag3);
    }

    @Test(dataProvider = "negative data with exception", expectedExceptions = Exception.class)
    public void testNegativeType(double a, double b, double c, String notUse) throws Exception {
        triangle = new Triangle(a, b, c);
    }

    @Test(dataProvider = "negative data invalid values")
    public void testNegativeInvalidValues(double a, double b, double c, String expected) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.type(), expected);
    }

    @Test(dataProvider = "positive data")
    public void testPositiveType(double a, double b, double c, String expected) throws Exception {
        triangle = new Triangle(a, b, c);
        assertEquals(triangle.type(), expected);
    }
}