package pl.training.JDBC;

import com.sun.org.apache.xpath.internal.SourceTree;
import pl.training.JDBC.database.AddressDAO;
import pl.training.JDBC.database.AuthorDAO;
import pl.training.JDBC.database.ConnectionFactory;
import pl.training.JDBC.manager.AddressManager;
import pl.training.JDBC.manager.AuthorManager;
import pl.training.JDBC.manager.LibraryManager;
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


        AddressManager addressManager = new AddressManager();
        AuthorManager authorManager = new AuthorManager();
        LibraryManager libraryManager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        boolean runner = true;

        while(runner){
            System.out.print("Select class <address, author, library>: " );
            String classSelect = scanner.next();
            switch (classSelect){
                case "address":{

                    addressManager.manage(scanner);
                    break;
                }

                case "author":{

                    authorManager.manage(scanner);
                    break;
                }

                case "library":{
                    libraryManager.manage(scanner);
                    break;
                }
            }
        }












//        Training training = new Training();
//        training.executeTest();
    }



}
