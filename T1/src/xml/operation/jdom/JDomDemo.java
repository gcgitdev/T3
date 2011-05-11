/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package xml.operation.jdom;

import java.io.FileOutputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import xml.operation.XmlDocument;

public class JDomDemo implements XmlDocument {

    private static final String TEST_XML_SAMPLE_DOM = "test_xml_sample_1.xml";

    public void createXml(String fileName) {

        // add elements
        Element root = new Element("employees");
        Document document = new Document(root);
        Element employee = new Element("employee");
        Element name = new Element("name");
        Element sex = new Element("sex");
        Element age = new Element("age");

        root.addContent(employee);
        employee.addContent(name);
        employee.addContent(sex);
        employee.addContent(age);

        name.setText("John");
        sex.setText("m");
        age.setText("23");

        // output
        XMLOutputter XMLOut = new XMLOutputter();
        try {
            XMLOut.output(document, new FileOutputStream(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parserXml(String fileName) {
        SAXBuilder builder = new SAXBuilder(false);
        try {
            Document document = builder.build(fileName);
            Element employees = document.getRootElement();

            List employeeList = employees.getChildren("employee");
            for (int i = 0; i < employeeList.size(); i++) {
                Element employee = (Element) employeeList.get(i);

                List employeeInfo = employee.getChildren();
                for (int j = 0; j < employeeInfo.size(); j++) {
                    System.out.println(((Element) employeeInfo.get(j)).getName() + ":"
                            + ((Element) employeeInfo.get(j)).getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDomDemo demo = new JDomDemo();
        demo.createXml(TEST_XML_SAMPLE_DOM);
        demo.parserXml(TEST_XML_SAMPLE_DOM);
    }
}
