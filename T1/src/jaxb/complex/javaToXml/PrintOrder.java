package jaxb.complex.javaToXml;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "printOrder")
@XmlType(name = "PrintOrderType", propOrder = { "events" })
// bind all non-static, non-transient fields to XML unless annotated with @XmlTransient
@XmlAccessorType(XmlAccessType.FIELD)
public class PrintOrder {

    @XmlAttribute(required = true)
    private long id;

    // custom adapter maps this field to a type, NotificationsType, which makes it easy to generate the desired XML
    @XmlJavaTypeAdapter(value = EventAdapter.class)
    @XmlElement(name = "notifications")
    private List<Event> events;

    // JAXB needs this default constructor
    public PrintOrder() {
    }

    public PrintOrder(List<Event> events) {
        Calendar cal = new GregorianCalendar();
        this.id = cal.getTimeInMillis();
        this.events = events;
    }
}
