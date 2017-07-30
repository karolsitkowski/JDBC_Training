package pl.training.JDBC.database;

import pl.training.JDBC.model.Author;
import pl.training.JDBC.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 30.07.17.
 */
public class BookDAO extends BaseDAO<Book> {


    @Override
    public String getTableName(){
        return "books";
    }

    @Override
    public Book createObject(ResultSet result) throws SQLException{
        Book book = new Book();
        book.setIsbn(result.getString(1));
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = authorDAO.findById(result.getInt(2));
        book.setAuthor(author);
        book.setTitle(result.getString(3));
        book.setPublishDate(result.getDate(4));

        return book;
    }

    public Book findById(String isbn){

        String sql = "SELECT * FROM " + getTableName() + " WHERE isbn = ?";

        Book value = null;

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,isbn);
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createObject(result);
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return value;
    }


}