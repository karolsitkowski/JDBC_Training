package pl.training.JDBC.manager;

import pl.training.JDBC.database.LibraryDAO;
import pl.training.JDBC.model.Library;

/**
 * Created by sit0 on 29.07.17.
 */
public class LibraryManager extends BaseManager<Library,LibraryDAO> {

    public LibraryManager(){
        dao = new LibraryDAO();
    }

}
