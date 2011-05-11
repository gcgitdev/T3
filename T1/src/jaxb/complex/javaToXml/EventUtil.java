package jaxb.complex.javaToXml;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class EventUtil {

    public static List<Event> getEvents() {
        List<Event> events = new ArrayList<Event>();

        // create some data
        Address address = new Address("123 Whitewater Street", null, "OurTown", "CA", "90347", "1234");
        Calendar birthDate = new GregorianCalendar(2005, Calendar.SEPTEMBER, 1);
        Pet pet = new Pet("Honcho", "Dog", "Labrador Retriever", "M", birthDate.getTime());
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(pet);
        Owner owner = new Owner("Joe", "Outdoors", "630-456-7890", address, pets);
        Calendar apptDate = new GregorianCalendar(2008, Calendar.SEPTEMBER, 15);
        Appointment appt = new Appointment(owner, pet, "Yearly Checkup", apptDate.getTime());
        events.add(appt);

        address = new Address("456 Scenic Drive", null, "West OurTown", "CA", "90349", "6789");
        birthDate = new GregorianCalendar(2004, Calendar.APRIL, 23);
        pet = new Pet("Miss Kitty", "Cat", "Maine Coon", "F", birthDate.getTime());
        pets.clear();
        pets.add(pet);
        owner = new Owner("Missy", "Fairchild", "630-643-2137", address, pets);
        apptDate = new GregorianCalendar(2008, Calendar.SEPTEMBER, 12);
        appt = new Appointment(owner, pet, "Well Mom Exam", apptDate.getTime());
        events.add(appt);

        address = new Address("22375 Willow Court", null, "West OurTown", "CA", "90349", "6789");
        birthDate = new GregorianCalendar(2000, Calendar.SEPTEMBER, 7);
        pet = new Pet("Tom", "Cat", "Mix", "M", birthDate.getTime());
        pets.clear();
        pets.add(pet);
        owner = new Owner("Violet", "Flowers", "630-641-3343", address, pets);
        Birthday birthday = new Birthday(owner, pet);
        events.add(birthday);

        return events;
    }

}
