package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 28.07.17.
 */
public class AuthorDAO extends BaseDAO<Author> {

    @Override
    public String getTableName(){
        return "authors";
    }

    @Override
    public Author createFullObject(ResultSet result) throws SQLException{

        Author author = new Author();
        author.setId(result.getInt(1));
        AddressDAO addressDAO = new AddressDAO();
        Address address = addressDAO.findAllInfoById(result.getInt(2));
        author.setAddress(address);
        author.setFirstName(result.getString(3));
        author.setLastName(result.getString(4));
        //TODO Books
        return author;
    }

    public Author createTruncObject(ResultSet result) throws SQLException{

        Author author = new Author();
        author.setId(result.getInt(1));
        author.setFirstName(result.getString(3));
        author.setLastName(result.getString(4));
        return author;
    }
}
