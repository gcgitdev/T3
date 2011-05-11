package jaxb.complex.schemaToJava.print;

import jaxb.complex.schemaToJava.generated.*;

public class AppointmentPrinter implements Printer {
    
    private static final String LS = System.getProperty("line.separator");
    private static final String FIRST_NAME = ":firstName";
    private static final String SPECIES = ":species:";
    private static final String PET_NAME = ":petName:";
    private static final String APPT_TYPE = ":apptType:";
    private static final String DATE = ":date:";
    private static final String TEMPLATE = 
            "Hi " + FIRST_NAME + "!"
            + LS
            +  "Our records show that your " + SPECIES + " " + PET_NAME
            + " has a " + APPT_TYPE + " appointment scheduled on " + DATE + "."
            + LS
            + "Please call us 24 hours prior to your appointment if you need to reschedule."
            + LS
            + "Sincerely, NiceVet"
            + LS + LS;
     
    public void print(PrintItem item) {
        Appointment appointment = (Appointment)item;
        StringBuilder txt = new StringBuilder(AppointmentPrinter.TEMPLATE);
        int index = txt.indexOf(FIRST_NAME);
        txt.replace(index, index + FIRST_NAME.length(), appointment.getOwner().getFirstName());
        index = txt.indexOf(SPECIES);
        txt.replace(index, index + SPECIES.length(), appointment.getPet().getSpecies().toLowerCase());
        index = txt.indexOf(PET_NAME);
        txt.replace(index, index + PET_NAME.length(), appointment.getPet().getName());
        index = txt.indexOf(APPT_TYPE);
        txt.replace(index, index + APPT_TYPE.length(), appointment.getApptType().value());
        index = txt.indexOf(DATE);
        txt.replace(index, index + DATE.length(), appointment.getApptDate());
        System.out.print(txt);        
    }
}
