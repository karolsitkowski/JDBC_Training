package pl.training.JDBC.database;

import pl.training.JDBC.ServiceTest;
import pl.training.JDBC.model.Book;
import pl.training.JDBC.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Category createFullObject(ResultSet result) throws SQLException {

        Category category = new Category();
        category.setId(result.getInt(1));
        category.setName(result.getString(2));

        BooksAtCategoriesDAO booksAtCategoriesDAO = new BooksAtCategoriesDAO();
        List<String> isbns = booksAtCategoriesDAO.isbnListById(category.getId());
        List<Book> booksAtCategory = new ArrayList<>();
        BookDAO bookDAO = new BookDAO();
        for (String isbn : isbns){
            booksAtCategory.add(bookDAO.findIncompleteById(isbn));
        }
        category.setBooks(booksAtCategory);

        return category;
    }

    @Override
    public Category createTruncObject(ResultSet result) throws SQLException {
        Category category = new Category();
        category.setId(result.getInt(1));
        category.setName(result.getString(2));

        return category;
    }
}
