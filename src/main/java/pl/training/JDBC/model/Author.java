package pl.training.JDBC.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class Author {

    final String[] columns = {"id", "address_id", "first_name", "last_name"};

    private int id;

    private Address address;

    private String firstName;

    private String lastName;

    private List<Book> books;

    public String[] getColumns() {
        return columns;
    }

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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {

        String print = "firstName='" + firstName + '\'' +
                        " lastName='" + lastName + '\'';

        if(address != null){
            print += " address=[" + address + ']';
        }

        if(books != null){
            print += " author books=[" + books + ']';
        }

        return print;
    }
}
