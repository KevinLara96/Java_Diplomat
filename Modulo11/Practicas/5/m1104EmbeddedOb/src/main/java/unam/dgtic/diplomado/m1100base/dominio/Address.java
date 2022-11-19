package unam.dgtic.diplomado.m1100base.dominio;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Address {

    private String street;
    private String city;
    @Column(name = "PROVINCIA")
    private String state;
    @Column(name = "ZIP_CODE")
    private String zip;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    @Override
    public String toString() {
        return "Address [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
    }

}
