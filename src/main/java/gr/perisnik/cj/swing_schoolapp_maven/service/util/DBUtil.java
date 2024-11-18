package gr.perisnik.cj.swing_schoolapp_maven.service.util;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Utility class for managing database connections using Apache DBCP.
 * This class provides methods to obtain and close connections to the database.
 * 
 * @version 0.1
 * @author Peris Nik
 */
public class DBUtil {

    private static BasicDataSource ds = new BasicDataSource();
    private static Connection conn;
    
    /**
     * No instances of this class should be available.
     * This private constructor prevents the instantiation of this class.
     */
    private DBUtil() {}
    
    static {
        // Set the database URL, including the hostname, port, database name, and time zone.
        ds.setUrl("jdbc:mysql://localhost:3306/studentsdbcj?serverTimeZone=UTC");
        
        // Set the username for the database connection.
        ds.setUsername("sttdbcj");
        
        // Set the password for the database connection.
        ds.setPassword("perisnik123");
        
        // Set the initial size of the connection pool.
        ds.setInitialSize(8);
        
        // Set the maximum total number of connections allowed in the pool.
        ds.setMaxTotal(32);
        
        // Set the minimum number of idle connections that should be maintained in the pool.
        ds.setMinIdle(8);
        
        // Set the maximum number of idle connections that can be maintained in the pool.
        ds.setMaxIdle(10);
        
        // Set the maximum number of open prepared statements that can be used simultaneously.
        ds.setMaxOpenPreparedStatements(100);
    }
    
    /**
     * Obtains a connection to the database.
     * 
     * @return a connection to the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        try {
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.addSuppressed(null);
            throw e;
        }
        return conn;
    }
    
    /**
     * Closes the database connection if it is open.
     */
    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.addSuppressed(null);
        }
    }
}
