package jaxb.complex.javaToXml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class EventAdapter extends XmlAdapter<NotificationsType, List<Event>> {

    // adapt original Java construct to a type, NotificationsType, which we can easily map to the XML output we want
    @Override
    public NotificationsType marshal(List<Event> events) throws Exception {
        List<Appointment> appointments = new ArrayList<Appointment>();
        List<Birthday> birthdays = new ArrayList<Birthday>();

        for (Event e : events) {
            if (e instanceof Appointment) {
                appointments.add((Appointment) e);
            } else {
                birthdays.add((Birthday) e);
            }
        }
        return new NotificationsType(appointments, birthdays);
    }

    // map XML type to Java
    @Override
    public List<Event> unmarshal(NotificationsType notifications) throws Exception {
        List<Event> events = new ArrayList<Event>();
        events.addAll(notifications.getAppointments());
        events.addAll(notifications.getBirthdays());
        return events;
    }
}
