package jaxb.complex.javaToXml;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

    // the desired format
    private String pattern = "MM/dd/yyyy";

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat(pattern).format(date);
    }

    @Override
    public Date unmarshal(String dateString) throws Exception {
        return new SimpleDateFormat(pattern).parse(dateString);
    }
}
