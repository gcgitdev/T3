package jaxb.complex.javaToXml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AppointmentType", propOrder = { "apptType", "apptDate", "owner", "pet" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Appointment extends Event {

    @XmlElement(required = true)
    private String apptType;
    @XmlElement(required = true)
    private Date apptDate;

    public Appointment() {
    }

    public Appointment(Owner owner, Pet pet, String apptType, Date apptDate) {
        super(owner, pet);
        this.apptType = apptType;
        this.apptDate = apptDate;
    }

    public String getApptType() {
        return apptType;
    }

    public Date getApptDate() {
        return apptDate;
    }

}
