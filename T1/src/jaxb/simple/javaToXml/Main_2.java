/*------------------------------------------------------------------------------
 * COPYRIGHT Sample 2007
 *
 * The copyright to the computer program(s) herein is the property of
 * Sample Inc. The programs may be used and/or copied only with written
 * permission from Sample Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package jaxb.simple.javaToXml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import jaxb.simple.schemaToJava.Items;
import jaxb.simple.schemaToJava.ObjectFactory;
import jaxb.simple.schemaToJava.PurchaseOrderType;
import jaxb.simple.schemaToJava.USAddress;

/**
 * NOTE, depends on jaxb.simple.schemaToJava. So run the
 * jaxb.simple.schemaToJava/genCode.bat if there is no related classes
 */
public class Main_2 {

    public static void main(String[] args) throws Exception {
        // create an empty PurchaseOrder
        PurchaseOrderType po = new PurchaseOrderType();
        po.setOrderDate(getDate());
        po.setShipTo(createUSAddress("Alice Smith", "123 Maple Street", "Cambridge", "MA", "12345"));
        po.setBillTo(createUSAddress("Robert Smith", "8 Oak Avenue", "Cambridge", "MA", "12345"));
        po.setItems(createItems());

        // jaxb.simple.schemaToJava contains the JAXB-generated classes.
        JAXBContext jc = JAXBContext.newInstance("jaxb.simple.schemaToJava");
        JAXBElement<PurchaseOrderType> poElement = (new ObjectFactory()).createPurchaseOrder(po);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(poElement, new FileOutputStream("src/jaxb/simple/javaToXml/po.xml"));

        //gen xsd
        final File dir = new File("src/jaxb/simple/javaToXml");
        JAXBContext ctx = JAXBContext.newInstance(PurchaseOrderType.class);
        ctx.generateSchema(new SchemaOutputResolver() {
            @Override
            public Result createOutput(String namespaceUri, String schemaName) throws IOException {
                return new StreamResult(new File(dir, schemaName)); // the schema name will be "schema1.xsd" (default value?)
            }
        });
    }

    private static Items createItems() {
        Items items = new Items();
        List<Items.Item> itemList = items.getItem();
        itemList.add(createItem("Nosferatu (1929)", 5, new BigDecimal("19.99"), null, null, "242-NO"));
        itemList.add(createItem("The Mummy (1959)", 3, new BigDecimal("19.98"), null, null, "242-MU"));
        itemList.add(createItem("Godzilla and Mothra", 3, new BigDecimal("27.95"), null, null, "242-GZ"));
        return items;
    }

    public static USAddress createUSAddress(String name, String street, String city, String state, String zip) {
        USAddress address = new USAddress();
        address.setName(name);
        address.setStreet(street);
        address.setCity(city);
        address.setState(state);
        address.setZip(new BigDecimal(zip));
        return address;
    }

    public static Items.Item createItem(String productName, int quantity, BigDecimal price, String comment,
            XMLGregorianCalendar shipDate, String partNum) {
        Items.Item item = new Items.Item();
        item.setProductName(productName);
        item.setQuantity(quantity);
        item.setUSPrice(price);
        item.setComment(comment);
        item.setShipDate(shipDate);
        item.setPartNum(partNum);
        return item;
    }

    private static XMLGregorianCalendar getDate() throws Exception {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
    }
}