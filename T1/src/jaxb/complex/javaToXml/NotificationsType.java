package jaxb.complex.javaToXml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class NotificationsType {

    @XmlElementWrapper(name = "appointments")
    @XmlElement(name = "appointment")
    private List<Appointment> appointments;

    @XmlElementWrapper(name = "birthdays")
    @XmlElement(name = "birthday")
    private List<Birthday> birthdays;

    public NotificationsType() {
    }

    public NotificationsType(List<Appointment> appointments, List<Birthday> birthdays) {
        this.appointments = appointments;
        this.birthdays = birthdays;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public List<Birthday> getBirthdays() {
        return birthdays;
    }
}
