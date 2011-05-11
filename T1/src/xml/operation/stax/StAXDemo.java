/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package xml.operation.stax;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

import xml.operation.XmlDocument;

public class StAXDemo implements XmlDocument {

    private static final String TEST_XML_SAMPLE_SAX = "test_xml_sample_1.xml";

    public void createXml(String fileName) {
        System.out.println("<< Can not use StAX create document >>");
    }

    public void parserXml(String fileName) {
        try {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            InputStream in = new FileInputStream(fileName);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals("employees")) {
                        event = eventReader.nextEvent();
                        System.out.println("================ End =================");
                        continue;
                    }
                }
                if (event.isStartElement()) {
                    if (event.asStartElement().getName().getLocalPart().equals("employees")) {
                        event = eventReader.nextEvent();
                        System.out.println("Employees: ");
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals("name")) {
                        event = eventReader.nextEvent();
                        System.out.println("name: " + event.asCharacters().getData());
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals("sex")) {
                        event = eventReader.nextEvent();
                        System.out.println("sex: " + event.asCharacters().getData());
                        continue;
                    }
                    if (event.asStartElement().getName().getLocalPart().equals("age")) {
                        event = eventReader.nextEvent();
                        System.out.println("age: " + event.asCharacters().getData());
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StAXDemo demo = new StAXDemo();
        demo.createXml(TEST_XML_SAMPLE_SAX);
        demo.parserXml(TEST_XML_SAMPLE_SAX);
    }
}
