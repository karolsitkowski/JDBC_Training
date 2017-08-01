package pl.training.JDBC;

import pl.training.JDBC.database.AddressDAO;
import pl.training.JDBC.database.ConnectionFactory;
import pl.training.JDBC.manager.AuthorManager;
import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Book;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sit0 on 28.07.17.
 */
public class ServiceTest {

    public static void main(String[] args) {

        test();
    }

    public static void test() {
        AddressDAO addressDAO = new AddressDAO();
        System.out.println(addressDAO.findParamDataById(1,new int[] {2}));

    }



    /*
    //public void executeTest(){
        Set<Address> addresses;
        Address address;

        try (Connection connection = ConnectionFactory.createConnection();) {
            if (connection.isValid(1)) {
                System.out.println("Connection is valid");

                addresses = addressesDownload(connection);

                for (Address addressIterator : addresses) {
                    System.out.println(addressIterator.getId() + " | " + addressIterator.getAddress() + " | " + addressIterator.getCity() + " | " + addressIterator.getPostalCode());
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Select Id to print");
                int id = scanner.nextInt();
                address = addressById(connection, id);
                //String[] columns = address.getColumns();
                System.out.print("Columns -> ");
                for (String column : columns) {
                    System.out.print(column + " | ");
                }
                System.out.println("\n" + "Data -> " + address.getId() + " | " + address.getAddress() + " | " + address.getCity() + " | " + address.getPostalCode());

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }


    //Statment training
  //  private Set<Address> addressesDownload(Connection connection) throws SQLException {
       //

    //PreparedStatement training
    private Address addressById(Connection connection, int id) {

        Address address = new Address();

        String sql = "SELECT * FROM addresses WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, id);

            System.out.println(preparedStatement.toString());

            try (ResultSet result = preparedStatement.executeQuery();) {
                while (result.next()) {
                    address.setId(result.getInt(1));
                    address.setAddress(result.getString(2));
                    address.setCity(result.getString(3));
                    address.setPostalCode(result.getString(4));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return address;
    }
    //ancillaty table prototype
    public Set<String> books_at_categories(int id) {

        Set<String> isbns = new HashSet<>();

        String sql = "select isbn from books_at_categories where category_id = ?";

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){
            preparedStatement.setInt(1, id);
            try (ResultSet result = preparedStatement.executeQuery();) {
                System.out.println(preparedStatement.toString());
                while (result.next()) {
                    isbns.add(result.getString(1));
                }
            }

        } catch (SQLException ex){
            System.out.println(ex);
        }

        return isbns;
    }
    */
}
