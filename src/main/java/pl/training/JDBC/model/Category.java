package pl.training.JDBC.model;

import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class Category {

    private int id;

    private String name;


    private List<Book> books;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {

        String toString = "Category{";
        if(id != 0){
            toString += "id=" + id + ", ";
        }
        toString += "name='" + name + '\'';
        if(books != null){
            toString += ", books=" + books;
        }
        toString += '}';

        return toString;
    }
}
