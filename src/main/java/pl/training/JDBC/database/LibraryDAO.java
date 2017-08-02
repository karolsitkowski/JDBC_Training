package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Book;
import pl.training.JDBC.model.Library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 29.07.17.
 */
public class LibraryDAO extends BaseDAO<Library> {

    @Override
    public String getTableName() {
        return "libraries";
    }

    @Override
    public int[] getAllColumns() {
        return new int[] {1,2,3,4};
    }

    @Override
    public Library createObject(ResultSet result, int[] columns) throws SQLException {
        Library library = new Library();
        for(int i : columns){
            switch(i){
                case 1:{
                    library.setId(result.getInt(1));
                    break;
                }
                case 2:{
                    AddressDAO addressDAO = new AddressDAO();
                    library.setAddress(addressDAO.findDataById(result.getInt(2), new int[]{2,3,4}));
                    break;
                }
                case 3:{
                    library.setLibName(result.getString(3));
                    break;
                }
                case 4:{
                    BooksAtLibrariesDAO booksAtLibrariesDAO = new BooksAtLibrariesDAO();
                    List<String> isbns = booksAtLibrariesDAO.isbnListById(result.getInt(1));
                    List<Book> books = new ArrayList<>();
                    BookDAO bookDAO = new BookDAO();
                    for(String isbn : isbns){
                        books.add(bookDAO.findDataById(isbn,new int[]{2,3,4}));
                    }
                    library.setBooks(books);
                    break;
                }
            }
        }

        return library;
    }

}
