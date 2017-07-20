package pl.training.JDBC;

import com.sun.org.apache.xpath.internal.SourceTree;
import pl.training.JDBC.database.ConnectionFactory;
import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Author;
import pl.training.JDBC.model.Book;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sit0 on 17.07.17.
 */
public class Terminal {


    public static void main(String[] args) {

        Set<Address> addresses = new HashSet<>();

        try (Connection connection = ConnectionFactory.createConnection();) {
            if (connection.isValid(1)) {
                System.out.println("Connection is valid");

                addresses = addressesDownload(connection);

                for (Address address : addresses) {
                    System.out.println(address.getId() + " | " + address.getAddress() + " | " + address.getCity() + " | " + address.getPostalCode());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }



    }

    public static Set<Address> addressesDownload(Connection connection) throws SQLException{
        String sql = "SELECT * FROM addresses";

        Set<Address> addresses = new HashSet<>();

        try(Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql)) {
            while(result.next()){
                Address address = new Address();
                address.setId(result.getInt("id"));
                address.setAddress(result.getString("address"));
                address.setCity(result.getString("city"));
                address.setPostalCode(result.getString("postal_code"));
                addresses.add(address);
            }
        }
        return addresses;
    }

}
