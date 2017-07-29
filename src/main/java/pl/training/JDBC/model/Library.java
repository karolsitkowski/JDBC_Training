package pl.training.JDBC.model;

import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class Library {

    private int id;

    private Address address;

    private String libName;


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

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return  "Name='" + libName + '\'' +
                " address=["  + address + ']' +
                " books=" + books;
    }
}
