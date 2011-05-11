package jaxb.complex.javaToXml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class A_Main {

    public static void main(String[] args) throws Exception {

        PrintOrder order = new PrintOrder(EventUtil.getEvents());

        final File dir = new File("src/jaxb/complex/javaToXml");
        JAXBContext ctx = JAXBContext.newInstance(PrintOrder.class);
        ctx.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String schemaName) throws IOException {
                return new StreamResult(new File(dir, "order.xsd")); // the schema name will be "schema1.xsd" (default value?)
            }
        });

        OutputStream os = new FileOutputStream("src/jaxb/complex/javaToXml/order.xml");
        Marshaller marshaller = ctx.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // JAXB_FORMATTED_OUTPUT specifies whether the marshaled XML is formatted with linefeeds and indentation
        marshaller.marshal(order, os); // marshal the data in the Java content tree to the XML instance document niceVet.xml
    }

}
