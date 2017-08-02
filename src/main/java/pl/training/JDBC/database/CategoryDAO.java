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
    public int[] getAllColumns() {
        return new int[] {1,2,3};
    }


    @Override
    public Category createObject(ResultSet result, int[] columns) throws SQLException {
        Category category = new Category();
        for(int i : columns){
            switch (i){
                case 1:{
                    category.setId(result.getInt(1));
                    break;
                }
                case 2:{
                    category.setName(result.getString(2));
                    break;
                }
                case 3:{
                    BooksAtCategoriesDAO booksAtCategoriesDAO = new BooksAtCategoriesDAO();
                    List<String> isbns = booksAtCategoriesDAO.isbnListById(category.getId());
                    List<Book> booksAtCategory = new ArrayList<>();
                    BookDAO bookDAO = new BookDAO();
                    for (String isbn : isbns){
                        booksAtCategory.add(bookDAO.findDataById(isbn,new int[] {1,2,3,4}));
                    }
                    category.setBooks(booksAtCategory);
                }
            }
        }
        return category;
    }
}
