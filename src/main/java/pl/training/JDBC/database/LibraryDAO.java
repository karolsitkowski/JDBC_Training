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
    public Library createFullObject(ResultSet result) throws SQLException {
        Library library = new Library();
        library.setId(result.getInt(1));
        library.setLibName(result.getString(3));
        AddressDAO addressDAO = new AddressDAO();
        int[] addressColumns = {1,2,3,4};
        Address address = addressDAO.findParamDataById(result.getInt(2), addressColumns);
        library.setAddress(address);

        return library;
    }

    @Override
    public Library createParamObject(ResultSet result, int[] columns) throws SQLException {
        Library library = new Library();
        library.setId(result.getInt(1));
        library.setLibName(result.getString(3));
        return library;
    }

}
