package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    private static ConnectionPool ourInstance = new ConnectionPool();

    public static ConnectionPool getInstance() {
        return ourInstance;
    }

    private ConnectionPool() {
    }

    public Connection getConnection() throws NamingException, SQLException {
        Context ctx;
        Connection connection;
        ctx = new InitialContext();
        DataSource dataSource = (DataSource)ctx.lookup("java:comp/env/jdbc/stock");;
        connection = dataSource.getConnection();
        return connection;
    }
}
