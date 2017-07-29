package pl.training.JDBC.manager;

import pl.training.JDBC.database.AddressDAO;
import pl.training.JDBC.model.Address;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sit0 on 29.07.17.
 */
public class AddressManager extends BaseManager<Address,AddressDAO> {

    public AddressManager(){
        dao = new AddressDAO();
    }
}
