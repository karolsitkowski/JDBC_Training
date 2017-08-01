package pl.training.JDBC.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sit0 on 28.07.17.
 */
public abstract class BaseDAO<T> {

    public abstract String getTableName();

    public abstract T createFullObject(ResultSet result) throws SQLException;

    public abstract T createParamObject(ResultSet result, int[] columns) throws SQLException;

    public List<T> findAll(){

        String sql = "SELECT * FROM " + getTableName();

        List<T> values = new ArrayList<>();

        try(Connection connection = ConnectionFactory.createConnection();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);) {
            System.out.println(statement.toString() + " from findAll() method BaseDAO");
            while (result.next()){
                T value = createFullObject(result);
                values.add(value);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return values;
    }

    public T findAllDataById(int id){

        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

        T value = null;

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            System.out.println(statement.toString() + " from findALL in BaseDAO");
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createFullObject(result);
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return value;
    }

    public T findParamDataById(int id, int[] columns){

        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";

        T value = null;

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1,id);
            System.out.println(statement.toString() + " from fintTrunc() BaseDAO");
            try(ResultSet result = statement.executeQuery()){
                if(result.next()){
                    value = createParamObject(result, columns);
                }
            }
        } catch (SQLException ex){
            System.out.println(ex);
        }
        return value;
    }

}
