package pl.training.JDBC.database;

import pl.training.JDBC.model.Book;
import pl.training.JDBC.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            booksAtCategory.add(bookDAO.findParamDataById(isbn,new int[] {1,2,3,4}));
        }
        category.setBooks(booksAtCategory);

        return category;
    }

    @Override
    public Category createParamObject(ResultSet result, int[] columns) throws SQLException {
        Category category = new Category();
        category.setId(result.getInt(1));
        category.setName(result.getString(2));

        return category;
    }
}
