package pl.training.JDBC.model;

import java.util.Date;
import java.util.List;

/**
 * Created by sit0 on 18.07.17.
 */
public class Book {

    private String isbn;

    private Author author;

    private String title;

    private Date publishDate;


    private List<User> users;

    private List<Library> libraries;

    private List<Category> categories;

//    public Book(String isbn, Author author, String title, Date date){
//
//        this.isbn = isbn;
//        this.author = author;
//        this.title = title;
//        this.publishDate = date;
//    }

}
