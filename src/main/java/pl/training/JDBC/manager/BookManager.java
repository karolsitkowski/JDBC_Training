package pl.training.JDBC.manager;

import pl.training.JDBC.database.BookDAO;
import pl.training.JDBC.model.Book;

import java.util.Scanner;

/**
 * Created by sit0 on 30.07.17.
 */
public class BookManager extends BaseManager<Book,BookDAO> {

    public BookManager(){
        dao = new BookDAO();
    }
    @Override
    protected void findById(Scanner scanner){
        System.out.println("Input ID: ");
        String id = scanner.next();
        Book value = dao.findDataById(id,dao.getAllColumns());
        System.out.println(value);
    }
}
