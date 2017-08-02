package pl.training.JDBC.database;

/**
 * Created by sit0 on 02.08.17.
 */
public class BooksAtUsersDAO extends AncillaryTablesDAO {
    @Override
    public String getTableName() {
        return "books_at_users";
    }
    @Override
    public String getIdColumnName() {
        return "user_id";
    }
}
