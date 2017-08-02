package pl.training.JDBC.database;

/**
 * Created by sit0 on 02.08.17.
 */
public class BooksAtLibrariesDAO extends AncillaryTablesDAO {
    @Override
    public String getTableName() {
        return "books_at_libraries";
    }
    @Override
    public String getIdColumnName() {
        return "library_id";
    }
}
