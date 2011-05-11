package jaxb.complex.javaToXml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AddressType", propOrder = { "addressLine1", "addressLine2", "city", "state", "zip", "zipExt" })
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

    @XmlTransient
    private long id;
    @XmlElement(required = true)
    private String addressLine1;
    private String addressLine2;
    @XmlElement(required = true)
    private String city;
    @XmlElement(required = true)
    private String state;
    @XmlElement(required = true)
    private String zip;
    private String zipExt;

    public Address() {
    }

    public Address(String addressLine1, String addressLine2, String city, String state, String zip, String zipExt) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.zipExt = zipExt;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZipExt() {
        return zipExt;
    }

    public void setZipExt(String zipExt) {
        this.zipExt = zipExt;
    }

}
