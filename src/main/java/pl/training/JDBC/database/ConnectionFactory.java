package pl.training.JDBC.database;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by sit0 on 18.07.17.
 */
public class ConnectionFactory {

    public static final String URL = "jdbc:mysql://localhost:3306/library";

    public static final String USER = "library_admin";

    public static final String PASSWORD = "1234";

    public static final String PARAMS = "?useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false"
            + "&serverTimezone=UTC"
            + "&verifyServerCertificate=false"
            + "&useSSL=true";

    /* Connection without pool
    public static Connection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL + PARAMS, USER, PASSWORD);
        return connection;
    }
    */

    private static BasicDataSource pool;

    public static Connection createConnection() throws SQLException{
            if (pool == null){
            pool = new BasicDataSource();
            pool.setUsername(USER);
            pool.setPassword(PASSWORD);
            pool.setUrl(URL + PARAMS);
        }
        Connection connection = pool.getConnection();
        return connection;
    }
}
