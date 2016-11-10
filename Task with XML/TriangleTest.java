import Task05.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
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
    private final String filePath = "E:/IdeaProjects/data_for_test.xml";

    Triangle triangle;

    File file = new File(filePath);

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(file);

    public TriangleTest() throws ParserConfigurationException, IOException, SAXException {
    }

    @DataProvider(name = "negative data with exception")
    public Object[][] getNegativeExceptionData() {
        Node node = document.getElementsByTagName("withException").item(0);
        NodeList nodeList = node.getChildNodes();
        Object[][] result = new Object[nodeList.getLength()][];

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem("sideA").getNodeValue()),
                    Double.parseDouble(map.getNamedItem("sideB").getNodeValue()),
                    Double.parseDouble(map.getNamedItem("sideC").getNodeValue()),
            };
        }
        return result;
    }

    @DataProvider(name = "negative data invalid values")
    public Object[][] getNegativeInvalidData() {
        Node node = document.getElementsByTagName("invalidValues").item(0);
        NodeList nodeList = node.getChildNodes();
        Object[][] result = new Object[nodeList.getLength()][];

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem("sideA").getNodeValue()),
                    Double.parseDouble(map.getNamedItem("sideB").getNodeValue()),
                    Double.parseDouble(map.getNamedItem("sideC").getNodeValue()),
                    map.getNamedItem("expected").getNodeValue()
            };
        }

        return result;
    }

    @DataProvider(name = "positive data")
    public Object[][] getPositiveData() {
        Node node = document.getElementsByTagName("positives").item(0);
        NodeList nodeList = node.getChildNodes();
        Object[][] result = new Object[nodeList.getLength()][];

        for (int i = 0; i < nodeList.getLength(); i++) {
            NamedNodeMap map = nodeList.item(i).getAttributes();
            result[i] = new Object[]{
                    Double.parseDouble(map.getNamedItem("sideA").getNodeValue()),
                    Double.parseDouble(map.getNamedItem("sideB").getNodeValue()),
                    Double.parseDouble(map.getNamedItem("sideC").getNodeValue()),
                    map.getNamedItem("expected").getNodeValue()
            };
        }

        return result;
    }

    @Test(dataProvider = "negative data with exception", expectedExceptions = Exception.class)
    public void testNegativeType(double a, double b, double c) throws Exception {
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