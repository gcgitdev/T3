package jaxb.complex.javaToXml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

// no need to capture this inheritance hierarchy in XML
@XmlTransient
public abstract class Event {

    @XmlElement(required = true)
    private Owner owner;
    @XmlElement(required = true)
    private Pet pet;

    public Event() {
    }

    public Event(Owner owner, Pet pet) {
        this.owner = owner;
        this.pet = pet;
    }

    public String getOwnerFirstName() {
        return owner.getFirstName();
    }

    public String getOwnerLastName() {
        return owner.getLastName();
    }

    public Address getAddress() {
        return owner.getAddress();
    }

    public String getPetName() {
        return pet.getName();
    }

    public String getSpecies() {
        return pet.getSpecies();
    }

    protected Pet getPet() {
        return pet;
    }

}
