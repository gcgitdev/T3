package jaxb.complex.xmlToJava;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import jaxb.complex.schemaToJava.generated.Appointment;
import jaxb.complex.schemaToJava.generated.Birthday;
import jaxb.complex.schemaToJava.generated.PrintOrder;

public class Main {

    public static void main(String[] args) throws Exception {

        // run /J2SE/src/jaxb/complex/javaToXml/A_Main.java if order.xml not there
        File input = new File("src/jaxb/complex/javaToXml/order.xml");

        JAXBContext ctx = JAXBContext.newInstance("jaxb.complex.schemaToJava.generated");

        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        JAXBElement printOrderElement = (JAXBElement) unmarshaller.unmarshal(new FileInputStream(input));
        PrintOrder printOrder = (PrintOrder) printOrderElement.getValue();

        List<Appointment> appointments = printOrder.getPrintItems().getAppointmentHolder().getAppointments();
        for (Appointment a : appointments) {
            a.print();
        }

        List<Birthday> birthdays = printOrder.getPrintItems().getBirthdayHolder().getBirthdays();
        for (Birthday b : birthdays) {
            b.print();
        }
    }
}
