import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL  = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "SYSTEM";
    private static final String PASS = "@Roydavid6238";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}