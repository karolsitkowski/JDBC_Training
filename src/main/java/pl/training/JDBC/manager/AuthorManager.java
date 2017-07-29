package pl.training.JDBC.manager;

import pl.training.JDBC.database.AuthorDAO;
import pl.training.JDBC.model.Author;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sit0 on 29.07.17.
 */
public class AuthorManager extends BaseManager<Author,AuthorDAO> {

    public AuthorManager(){
        dao = new AuthorDAO();
    }
}
