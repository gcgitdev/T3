//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.03.09 at 10:11:12 PM CST 
//


package jaxb.complex.schemaToJava.generated;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter2
    extends XmlAdapter<String, String>
{


    public String unmarshal(String value) {
        return (jaxb.complex.schemaToJava.print.CustomDataTypeConverter.parseDateTimeToString(value));
    }

    public String marshal(String value) {
        return (jaxb.complex.schemaToJava.print.CustomDataTypeConverter.printStringToDateTime(value));
    }

}
