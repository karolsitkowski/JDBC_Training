package pl.training.JDBC.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sit0 on 30.07.17.
 */
public abstract class AncillaryTablesDAO {

    public abstract String getTableName();

    public abstract String getIdColumnName();

    public List<Integer> idListByIsbn(String isbn){

        List<Integer> ids = new ArrayList<>();

        String sql = "SELECT " + getIdColumnName() +" FROM " + getTableName() + " WHERE isbn = ?";

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,isbn);
            System.out.println(preparedStatement.toString());
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    ids.add(resultSet.getInt(1));
                }
            }
        } catch (SQLException ex){
            System.out.println();
        }
        return ids;
    }

    public List<String> isbnListById(int id){

        List<String> isbns = new ArrayList<>();

        String sql = "SELECT isbn FROM " + getTableName() + " WHERE " + getIdColumnName() + " = ?";

        try(Connection connection = ConnectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement.toString());
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    isbns.add(resultSet.getString(1));
                }
            }
        } catch (SQLException ex){
            System.out.println();
        }
        return isbns;
    }

}
