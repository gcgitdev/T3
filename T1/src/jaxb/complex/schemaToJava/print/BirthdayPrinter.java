package jaxb.complex.schemaToJava.print;

import jaxb.complex.schemaToJava.generated.Birthday;

public class BirthdayPrinter implements Printer {

    private static final String LS = System.getProperty("line.separator");
    private static final String FIRST_NAME = ":firstName";
    private static final String SPECIES = ":species:";
    private static final String PET_NAME = ":petName:";
    private static final String AGE = ":age:";
    private static final String DATE = ":date:";
    private static final String TEMPLATE = "Hi " + FIRST_NAME + "!" + LS + "Our records show that your " + SPECIES
            + " " + PET_NAME + " will turn " + AGE + " years old on " + DATE + "." + LS + "Happy Birthday, " + PET_NAME
            + ", from all of us at NiceVet!" + LS + LS;

    public void print(PrintItem item) {
        Birthday birthday = (Birthday) item;
        StringBuilder txt = new StringBuilder(BirthdayPrinter.TEMPLATE);
        int index = txt.indexOf(FIRST_NAME);
        txt.replace(index, index + FIRST_NAME.length(), birthday.getOwner().getFirstName());
        index = txt.indexOf(SPECIES);
        txt.replace(index, index + SPECIES.length(), birthday.getPet().getSpecies().toLowerCase());
        index = txt.indexOf(PET_NAME);
        txt.replace(index, index + PET_NAME.length(), birthday.getPet().getName());
        index = txt.indexOf(AGE);
        txt.replace(index, index + AGE.length(), Integer.toString(birthday.getAge()));
        index = txt.indexOf(DATE);
        txt.replace(index, index + DATE.length(), birthday.getBirthday());
        index = txt.indexOf(PET_NAME);
        txt.replace(index, index + PET_NAME.length(), birthday.getPet().getName());
        System.out.print(txt);
    }
}
