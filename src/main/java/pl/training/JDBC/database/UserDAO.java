package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 30.07.17.
 */
public class UserDAO extends BaseDAO<User> {


    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public User createFullObject(ResultSet result) throws SQLException {

        User user = new User();
        user.setId(result.getInt(1));
        AddressDAO addressDAO = new AddressDAO();
        Address address = addressDAO.findAllDataById(result.getInt(2));
        user.setAddress(address);
        user.setFirstName(result.getString(3));
        user.setLastName(result.getString(4));
        user.setGender(User.Gender.valueOf(result.getString(5)));
        user.setEmail(result.getString(6));
        user.setPhoneNo(result.getString(7));
        return user;
    }

    @Override
    public User createParamObject(ResultSet result, int[] columns) throws SQLException {
        User user = new User();
        user.setId(result.getInt(1));
        user.setFirstName(result.getString(3));
        user.setLastName(result.getString(4));
        user.setGender(User.Gender.valueOf(result.getString(5)));
        user.setEmail(result.getString(6));
        user.setPhoneNo(result.getString(7));
        return user;
    }
}
