package pl.training.JDBC.database;

import pl.training.JDBC.model.Author;
import pl.training.JDBC.model.Book;
import pl.training.JDBC.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 30.07.17.
 */
public class BookDAO extends BaseDAO<Book> {


    @Override
    public String getTableName(){
        return "books";
    }

    @Override
    public Book createFullObject(ResultSet result) throws SQLException{
        Book book = new Book();
        book.setIsbn(result.getString(1));
        AuthorDAO authorDAO = new AuthorDAO();
        int[] authorColumns = {1,3,4};
        Author author = authorDAO.findParamDataById(result.getInt(2), authorColumns);
        book.setAuthor(author);
        book.setTitle(result.getString(3));
        book.setPublishDate(result.getDate(4));

        BooksAtCategoriesDAO booksAtCategoriesDAO = new BooksAtCategoriesDAO();
        List<Integer> categoriesIds = booksAtCategoriesDAO.idListByIsbn(book.getIsbn());
        List<Category> categories = new ArrayList<>();
        CategoryDAO categoryDAO = new CategoryDAO();
        int[] categoryColumns = {1,2};
        for (Integer id : categoriesIds){
            categories.add(categoryDAO.findParamDataById(id, categoryColumns));
        }
        book.setCategories(categories);

        return book;
    }

    public Book createParamObject(ResultSet result, int[] columns) throws SQLException{
        Book book = new Book();
        book.setIsbn(result.getString(1));
        AuthorDAO authorDAO = new AuthorDAO();
        Author author = authorDAO.findParamDataById(result.getInt(2), columns);
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
            System.out.println(statement.toString() + " from findByID Book");
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createFullObject(result);
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return value;
    }

    public Book findParamDataById(String isbn, int[] columns){

        String sql = "SELECT * FROM " + getTableName() + " WHERE isbn = ?";

        Book value = null;

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,isbn);
            System.out.println(statement.toString() + " from findIncompleteByID Book");
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createParamObject(result, columns);
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return value;
    }

    public List<Book> findBooksByAuthorId(int id){

        String sql = "SELECT * FROM " + getTableName() + " WHERE author_id = ?";

        List<Book> books = new ArrayList<>();

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            System.out.println(statement.toString() + " from findBooksByAuthorId()");
            int[] bookColumns = {1,3,4};
            try(ResultSet result = statement.executeQuery()){
                while(result.next()){
                    books.add(createParamObject(result,bookColumns));
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return books;
    }




}
