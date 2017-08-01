package pl.training.JDBC.database;

/**
 * Created by sit0 on 31.07.17.
 */
public class BooksAtCategoriesDAO extends AncillaryTablesDAO {

    @Override
    public String getTableName() {
        return "books_at_categories";
    }

    @Override
    public String getIdColumnName() {
        return "category_id";
    }
}
