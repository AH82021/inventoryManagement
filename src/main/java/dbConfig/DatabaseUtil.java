package dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// SOLID
public class DatabaseUtil {
    private static  final String DB_URL = "jdbc:mysql://localhost:3306/inventory";
    private static final String  USER = "root";
    private static final String PASSWORD = "arman2015";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,USER,PASSWORD);
    }
}
