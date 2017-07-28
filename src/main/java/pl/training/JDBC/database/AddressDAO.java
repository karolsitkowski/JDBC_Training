package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 28.07.17.
 */
public class AddressDAO extends BaseDAO<Address>  {

    public String getTableName(){
        return "addresses";
    }

    public Address createClass(ResultSet result) throws SQLException{

        Address address = new Address();
        address.setId(result.getInt(1));
        address.setAddress(result.getString(2));
        address.setCity(result.getString(3));
        address.setPostalCode(result.getString(4));

        return address;
    }
}
