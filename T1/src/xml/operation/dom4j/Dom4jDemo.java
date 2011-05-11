/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package xml.operation.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import xml.operation.XmlDocument;

public class Dom4jDemo implements XmlDocument {

    private static final String TEST_XML_SAMPLE_DOM = "test_xml_sample_1.xml";

    public void createXml(String fileName) {
        // add elements
        Document document = DocumentHelper.createDocument();
        Element employees = document.addElement("employees");
        Element employee = employees.addElement("employee");
        Element name = employee.addElement("name");
        Element sex = employee.addElement("sex");
        Element age = employee.addElement("age");
        name.setText("John");
        sex.setText("m");
        age.setText("29");

        try {
            Writer fileWriter = new FileWriter(fileName);
            XMLWriter xmlWriter = new XMLWriter(fileWriter);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parserXml(String fileName) {
        File inputXml = new File(fileName);
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(inputXml);

            Element employees = document.getRootElement();
            for (Iterator i = employees.elementIterator(); i.hasNext();) {

                Element employee = (Element) i.next();
                for (Iterator j = employee.elementIterator(); j.hasNext();) {
                    Element node = (Element) j.next();
                    System.out.println(node.getName() + ":" + node.getText());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println("================ End =================");
    }

    public static void main(String[] args) {
        Dom4jDemo demo = new Dom4jDemo();
        demo.createXml(TEST_XML_SAMPLE_DOM);
        demo.parserXml(TEST_XML_SAMPLE_DOM);
    }
}
