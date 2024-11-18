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
        ds.setUrl("jdbc:mysql://localhost:3306/studentsdbcj?serverTimeZone=UTC");
        ds.setUsername("sttdbcj");
        ds.setPassword("perisnik123");
        ds.setInitialSize(8);
        ds.setMaxTotal(32);
        ds.setMinIdle(8);
        ds.setMaxIdle(10);
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