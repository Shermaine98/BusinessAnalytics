package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atayan
 * @author Lapidario
 * @author Roxas
 * @author Sy
 *
 */
public class DBConnectionFactoryImpl extends DBConnectionFactory {

    /**
     *
     * @return
     */
    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectionFactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
