package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Library;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 29.07.17.
 */
public class LibraryDAO extends BaseDAO<Library> {

    @Override
    public String getTableName() {
        return "libraries";
    }

    @Override
    public Library createObject(ResultSet result) throws SQLException {
        Library library = new Library();
        library.setId(result.getInt(1));
        library.setLibName(result.getString(3));
        AddressDAO addressDAO = new AddressDAO();
        Address address = addressDAO.findById(result.getInt(2));
        library.setAddress(address);
        return library;
    }

}
