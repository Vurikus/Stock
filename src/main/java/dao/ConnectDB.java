package dao;

import logic.Thing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDB
{
    //Field
    private String URL = "jdbc:postgresql://localhost:5432/stockDB";
    private String user = "postgres";
    private String password = "1";
    private Connection connection;
    private static ConnectDB connectDB = new ConnectDB();
    //Constructor

    private ConnectDB() {

        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Connect is ready");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Function


    public static ConnectDB getConnectDB() {
        return connectDB;
    }

    public void insertThingDB (Thing thing){
        try {
            PreparedStatement statement = connection.prepareStatement("insert into things (namething, quantity) values (?, ?)");
            statement.setString(1, thing.getNameThing());
            statement.setInt(2, thing.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Thing> selectFromDB (){
        List <Thing> list = new ArrayList<>();
        try {
            ResultSet resultSet = connection
                    .prepareStatement("select * from things")
                    .executeQuery();
            while (resultSet.next()) {
                Thing thing = new Thing();
                thing.setID(resultSet.getInt("id"));
                thing.setNameThing(resultSet.getString("namething"));
                thing.setQuantity(resultSet.getInt("quantity"));
                list.add(thing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
