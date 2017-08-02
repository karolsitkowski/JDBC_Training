package pl.training.JDBC.model;

import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class User {

    public enum Gender {Male,Female}

    private int id;

    private Address address;

    private String firstName;

    private String lastName;

    private Gender gender;

    private String eMail;

    private String phoneNo;


    private List<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String geteMail() {
        return eMail;
    }

    public void setEmail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {

        String toString = "User{";
        if (id != 0) {
            toString += "id=" + id;
        }
        toString += "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
        if (address != null) {
            toString += ", address=" + address;
        }
        if(gender != null){
            toString += ", gender=" + gender;
        }
        if(eMail != null){
            toString += ", eMail='" + eMail + '\'';
        }
        if(phoneNo != null){
            toString += ", phoneNo='" + phoneNo + '\'';
        }
        if (books != null) {
            toString += ", books=" + books;
        }
        toString += '}';

        return toString;
    }
}
