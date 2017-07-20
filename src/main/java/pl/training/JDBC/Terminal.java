package pl.training.JDBC;

import pl.training.JDBC.database.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sit0 on 17.07.17.
 */
public class Terminal {
    public static void main(String[] args) {

        try(Connection connection = ConnectionFactory.createConnection();){
            if(connection.isValid(1)){
                System.out.println("Connection is valid");
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
    }
}
