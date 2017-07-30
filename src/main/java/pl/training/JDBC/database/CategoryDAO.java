package pl.training.JDBC.database;

import pl.training.JDBC.ServiceTest;
import pl.training.JDBC.model.Book;
import pl.training.JDBC.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by sit0 on 30.07.17.
 */
public class CategoryDAO extends BaseDAO<Category> {

    @Override
    public String getTableName() {
        return "categories";
    }

    @Override
    public Category createObject(ResultSet result) throws SQLException {

        Category category = new Category();
        category.setId(result.getInt(1));
        category.setName(result.getString(2));

        ServiceTest serviceTest = new ServiceTest();

        Set<String> isbns = serviceTest.books_at_categories(category.getId());
        BookDAO bookDAO = new BookDAO();
        List<Book> booksAtCategory = new LinkedList<>();

        for (String isbn : isbns){
            booksAtCategory.add(bookDAO.findById(isbn));
        }
        category.setBooks(booksAtCategory);

        return category;
    }
}
