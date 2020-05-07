package dao;

import logic.Thing;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleConnection {
    //Field
    private ConnectionPool connectionPool;
    private Connection connection;

    //Constructor

    public SimpleConnection() throws SQLException, NamingException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    //Function

    public void insertThingDB (Thing thing){
        try {
            PreparedStatement statement = connection.prepareStatement("insert into things (thing_name, quantity, life_time, date_added) values (?, ?, ?, ?)");
            statement.setString(1, thing.getNameThing());
            statement.setInt(2, thing.getQuantity());
            statement.setFloat(3, thing.getLifeTime());
            statement.setDate(4, thing.getAddThingDate());
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
                thing.setID(resultSet.getInt("thing_id"));
                thing.setNameThing(resultSet.getString("thing_name"));
                thing.setQuantity(resultSet.getInt("quantity"));
                thing.setLifeTime(resultSet.getFloat("life_time"));
                thing.setAddThingDate(resultSet.getDate("date_added"));
                list.add(thing);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
