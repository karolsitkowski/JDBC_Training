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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return  "isbn='" + isbn + '\'' +
                " author=[" + author + "]" +
                " title='" + title + '\'' +
                " publishDate='" + publishDate + '\'' +
                " users=" + users +
                " libraries=" + libraries +
                " categories=" + categories +"\n";
    }
}
