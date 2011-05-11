package jaxb.complex.schemaToJava.print;

import java.util.HashMap;
import java.util.Map;

public abstract class PrintItem {

    private static final Map<String, Printer> printers;

    static {
        printers = new HashMap<String, Printer>();
        printers.put("jaxb.complex.schemaToJava.generated.Birthday", new BirthdayPrinter());
        printers.put("jaxb.complex.schemaToJava.generated.Appointment", new AppointmentPrinter());
    }

    public void print() {
        Printer p = this.getPrinter();
        p.print(this);
    }

    private Printer getPrinter() {
        return printers.get(this.getClass().getName());
    }
}
