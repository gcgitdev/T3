package jaxb.complex.javaToXml;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "BirthdayType", propOrder = { "age", "birthday", "owner", "pet" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Birthday extends Event {

    @XmlElement(required = true)
    private int age;

    public Birthday() {
    }

    public Birthday(Owner owner, Pet pet) {
        super(owner, pet);
        this.age = this.calculateAge();
    }

    @XmlElement(name = "birthday", required = true)
    public Date getBirthday() {
        return this.getPet().getDateOfBirth();
    }

    public int getAge() {
        return age;
    }

    private int calculateAge() {
        Calendar today = new GregorianCalendar();
        Calendar birthday = new GregorianCalendar();
        birthday.setTime(this.getBirthday());
        int years = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

        if ((birthday.get(Calendar.MONTH) > today.get(Calendar.MONTH))
                || ((birthday.get(Calendar.MONTH) == today.get(Calendar.MONTH)) && (birthday.get(Calendar.DAY_OF_MONTH) > today
                        .get(Calendar.DAY_OF_MONTH)))) {
            years--;
        }

        return years;
    }
}
