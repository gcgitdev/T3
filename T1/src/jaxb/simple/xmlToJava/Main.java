package jaxb.simple.xmlToJava;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import jaxb.simple.schemaToJava.PurchaseOrderType;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Main {

    public static void main(String[] args) throws Exception {

        // run /J2SE/src/jaxb/simple/javaToXml/Main_2.java if po.xml not there
        File input = new File("src/jaxb/simple/javaToXml/po.xml");

        JAXBContext ctx = JAXBContext.newInstance("jaxb.simple.schemaToJava");

        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        JAXBElement po = (JAXBElement) unmarshaller.unmarshal(new FileInputStream(input));
        PurchaseOrderType purchaseOrderType = (PurchaseOrderType) po.getValue();

        System.out.println(ReflectionToStringBuilder.toString(purchaseOrderType));
    }
}
