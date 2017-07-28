package pl.training.JDBC.model;

import java.util.Arrays;

/**
 * Created by sit0 on 18.07.17.
 */
public class Address {

    final String [] columns = {"id", "address", "city", "postal_code"};

    private int id;

    private String address;

    private String city;

    private String postalCode;


    public String[] getColumns() {
        return columns;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'';
    }
}
