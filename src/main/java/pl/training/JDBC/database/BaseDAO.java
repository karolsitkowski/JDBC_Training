package pl.training.JDBC.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 28.07.17.
 */
public abstract class BaseDAO<T> {

    public abstract String getTableName();

    public abstract T createClass(ResultSet result) throws SQLException;

    public List<T> findAll(){

        String sql = "SELECT * FROM " + getTableName();

        List<T> values = new ArrayList<T>();

        try(Connection connection = ConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);) {

            while (result.next()){
                T value = createClass(result);
                values.add(value);
            }

        }catch (SQLException ex){
            System.out.println(ex);
        }
        return values;
    }

    public T findById(int id){

        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

        T value = null;

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createClass(result);
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return value;
    }

}
