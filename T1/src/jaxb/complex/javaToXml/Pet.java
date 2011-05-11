package jaxb.complex.javaToXml;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PetType", propOrder = { "name", "species" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Pet {

    @XmlTransient
    private long id;
    @XmlElement(required = true)
    private String name;
    private String species;
    @XmlTransient
    private String breed;
    @XmlTransient
    private String sex;
    @XmlTransient
    private Date dateOfBirth;

    public Pet() {
    }

    public Pet(String name, String species, String breed, String sex, Date dateOfBirth) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
