/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package xml.operation.dom;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import xml.operation.XmlDocument;

public class DomDemo implements XmlDocument {

    private static final String TEST_XML_SAMPLE_DOM = "test_xml_sample_1.xml";

    public void createXml(String fileName) {

        // create a document
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        // add elements
        Element root = document.createElement("employees");
        Element employee = document.createElement("employee");
        Element name = document.createElement("name");
        Element sex = document.createElement("sex");
        Element age = document.createElement("age");
        Text nameNode = document.createTextNode("John");
        Text sexNode = document.createTextNode("male");
        Text ageNode = document.createTextNode("30");

        document.appendChild(root);
        root.appendChild(employee);
        employee.appendChild(name);
        employee.appendChild(sex);
        employee.appendChild(age);
        name.appendChild(nameNode);
        sex.appendChild(sexNode);
        age.appendChild(ageNode);

        // write to a file
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
            StreamResult result = new StreamResult(pw);

            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            transformer.transform(source, result);
            System.out.println("Create XML Document success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fileName);

            NodeList employeesList = doc.getChildNodes();
            for (int i = 0; i < employeesList.getLength(); i++) {
                Node employee = employeesList.item(i);

                NodeList employeeInfo = employee.getChildNodes();
                for (int j = 0; j < employeeInfo.getLength(); j++) {
                    Node node = employeeInfo.item(j);

                    NodeList employeeMeta = node.getChildNodes();
                    for (int k = 0; k < employeeMeta.getLength(); k++) {
                        System.out.println(employeeMeta.item(k).getNodeName() + ":"
                                + employeeMeta.item(k).getTextContent());
                    }
                }
            }
            System.out.println("================ End =================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DomDemo demo = new DomDemo();
        demo.createXml(TEST_XML_SAMPLE_DOM);
        demo.parserXml(TEST_XML_SAMPLE_DOM);
    }
}