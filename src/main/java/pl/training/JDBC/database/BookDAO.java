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
    public int[] getAllColumns() {
        return new int[] {1,2,3,4,5,6,7};
    }

    public Book createObject(ResultSet result, int[] columns) throws SQLException{
        Book book = new Book();

        for(int i : columns){
            switch(i){
                case 1:{
                    book.setIsbn(result.getString(1));
                    break;
                }
                case 2:{
                    AuthorDAO authorDAO = new AuthorDAO();
                    book.setAuthor(authorDAO.findDataById(result.getInt(2), new int[] {3,4}));
                    break;
                }
                case 3:{
                    book.setTitle(result.getString(3));
                    break;
                }
                case 4:{
                    book.setPublishDate(result.getDate(4));
                    break;
                }
                case 5:{

                }
                case 6:{

                }
                case 7:{
                    BooksAtCategoriesDAO booksAtCategoriesDAO = new BooksAtCategoriesDAO();
                    List<Integer> categoriesIds = booksAtCategoriesDAO.idListByIsbn(book.getIsbn());
                    List<Category> categories = new ArrayList<>();
                    CategoryDAO categoryDAO = new CategoryDAO();
                    for (Integer id : categoriesIds){
                        categories.add(categoryDAO.findDataById(id, new int[] {2}));
                    }
                    book.setCategories(categories);
                    break;
                }

            }
        }
        return book;
    }

    public Book findDataById(String isbn, int[] columns){

        String sql = "SELECT * FROM " + getTableName() + " WHERE isbn = ?";

        Book value = null;

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1,isbn);
            System.out.println(statement.toString() + " findDataById() from BookDAO");
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createObject(result,columns);
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
            System.out.println(statement.toString() + " findBooksByAuthorId() from BookDAO");
            try(ResultSet result = statement.executeQuery()){
                while(result.next()){
                    books.add(createObject(result,new int[] {1,3,4}));
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return books;
    }
}
