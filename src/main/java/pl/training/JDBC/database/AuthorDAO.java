package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Author;
import pl.training.JDBC.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sit0 on 28.07.17.
 */
public class AuthorDAO extends BaseDAO<Author> {

    @Override
    public String getTableName(){
        return "authors";
    }

    @Override
    public int[] getAllColumns() {
        return new int[] {1,2,3,4,5};
    }

    public Author createObject(ResultSet result, int[] columns) throws SQLException{

        Author author = new Author();

        for(int i : columns){
            switch (i){
                case 1:{
                    author.setId(result.getInt(1));
                    break;
                }
                case 2:{
                    AddressDAO addressDAO = new AddressDAO();
                    author.setAddress(addressDAO.findDataById(result.getInt(2),new int[] {2,3,4}));
                    break;
                }
                case 3:{
                    author.setFirstName(result.getString(3));
                    break;
                }
                case 4:{
                    author.setLastName(result.getString(4));
                    break;
                }
                case 5:{
                    BookDAO bookDAO = new BookDAO();
                    author.setBooks(bookDAO.findBooksByAuthorId(result.getInt(1)));
                    break;
                }


            }
        }
        return author;
    }
}
