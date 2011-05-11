package jaxb.complex.schemaToJava.print;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IdAdapter extends XmlAdapter<String, PrintOrderKey> {

    // when marshalling a Java content tree to an XML instance document, move
    // from the type we work with in Java (PrintOrderKey) to the type JAXB understands
    @Override
    public String marshal(PrintOrderKey key) throws Exception {
        return key.getOrderId().toString();
    }

    // when unmarshalling an XML instance document to a Java content tree, move
    // from the type JAXB understands (String) to the type we want to work with
    // in Java
    @Override
    public PrintOrderKey unmarshal(String id) throws Exception {
        // WePrintStuff uses natural keys; add client name and
        // convert String id to required Long
        return new PrintOrderKey("NICEVET", new Long(id));
    }
}
