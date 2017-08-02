package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Book;
import pl.training.JDBC.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 30.07.17.
 */
public class UserDAO extends BaseDAO<User> {


    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public int[] getAllColumns() {
        return new int[] {1,2,3,4,5,6,7,8};
    }

    @Override
    public User createObject(ResultSet result, int[] columns) throws SQLException {
        User user = new User();
        for(int i : columns){
            switch (i){
                case 1:{
                    user.setId(result.getInt(1));
                    break;
                }
                case 2:{
                    AddressDAO addressDAO = new AddressDAO();
                    user.setAddress(addressDAO.findDataById(result.getInt(2),new int[]{2,3,4}));
                }
                case 3:{
                    user.setFirstName(result.getString(3));
                    break;
                }
                case 4:{
                    user.setLastName(result.getString(4));
                    break;
                }
                case 5:{
                    user.setGender(User.Gender.valueOf(result.getString(5)));
                    break;
                }
                case 6:{
                    user.setEmail(result.getString(6));
                    break;
                }
                case 7:{
                    user.setPhoneNo(result.getString(7));
                    break;
                }
                case 8:{
                    BooksAtUsersDAO booksAtUsersDAO = new BooksAtUsersDAO();
                    List<String> isbns = booksAtUsersDAO.isbnListById(result.getInt(1));
                    BookDAO bookDAO = new BookDAO();
                    List<Book> books = new ArrayList<>();
                    for (String isbn : isbns){
                        books.add(bookDAO.findDataById(isbn,new int[]{2,3,4}));
                    }
                    user.setBooks(books);
                    break;

                }
            }
        }
        return user;
    }
}
