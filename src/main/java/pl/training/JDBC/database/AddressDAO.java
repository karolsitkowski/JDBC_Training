package pl.training.JDBC.database;

import pl.training.JDBC.model.Address;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 28.07.17.
 */
public class AddressDAO extends BaseDAO<Address>  {

    @Override
    public String getTableName(){
        return "addresses";
    }

    @Override
    public int[] getAllColumns() {
        return new int[] {1,2,3,4};
    }

    @Override
    public Address createObject(ResultSet result, int[] columns) throws SQLException {
        Address address = new Address();

        for(int i : columns){
            switch(i){
                case 1:{
                    address.setId(result.getInt(1));
                    break;
                }
                case 2:{
                    address.setAddress(result.getString(2));
                    break;
                }
                case 3:{
                    address.setCity(result.getString(3));
                    break;
                }
                case 4:{
                    address.setPostalCode(result.getString(4));
                    break;
                }
            }
        }
        return address;
    }

}
