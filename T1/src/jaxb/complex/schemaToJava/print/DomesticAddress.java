package jaxb.complex.schemaToJava.print;

public class DomesticAddress {

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String zipExt;

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

    public String getCountry() {
        return "USA";
    }
}
