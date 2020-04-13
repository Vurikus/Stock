import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB
{
    //Field
    private String URL = "jdbc:postgresql://localhost:5432/stockDB";
    private String user = "postgres";
    private String password = "1";
    private Connection connection;
    //Constructor

    public ConnectDB() {

        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connect is ready");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Function


    public Connection getConnection() {
        return connection;
    }
}
