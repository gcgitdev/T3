package jaxb.complex.schemaToJava.print;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.DatatypeConverter;

public class CustomDataTypeConverter {

    // the desired format
    private static final String pattern = "MM/dd/yyyy";

    public static String parseDateTimeToString(String xsdDateTime) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(xsdDateTime);
        } catch (ParseException e) {
            // Can not throw excpetion here
            e.printStackTrace();
        }
        return date.toString();
        // use functionality provided by javax.xml.bind.DatatypeConverter to get us partway there...
        //Calendar cal = DatatypeConverter.parseDateTime(xsdDateTime);
        //return new SimpleDateFormat(pattern).format(cal.getTime());

    }

    public static String printStringToDateTime(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat(pattern).parse(dateString);
        } catch (ParseException e) {
            // Can not throw excpetion here
            e.printStackTrace();
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        // use functionality provided by javax.xml.bind.DatatypeConverter to finish the conversion
        return DatatypeConverter.printDateTime(cal);
    }

}
