package pl.training.JDBC;

import com.sun.org.apache.xpath.internal.SourceTree;
import pl.training.JDBC.database.AddressDAO;
import pl.training.JDBC.database.ConnectionFactory;
import pl.training.JDBC.model.Address;
import pl.training.JDBC.model.Author;
import pl.training.JDBC.model.Book;

import java.sql.*;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sit0 on 17.07.17.
 */
public class Terminal {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddressDAO addressDAO = new AddressDAO();
        List<Address> addresses = addressDAO.findAll();
        System.out.println("Adresses: ");
        for (Address address : addresses){
            System.out.println(address);
        }







//        Training training = new Training();
//        training.executeTest();
    }



}
