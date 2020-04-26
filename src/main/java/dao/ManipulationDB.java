package dao;

import logic.Thing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManipulationDB {
    //Field
    private String table = "things (nameThing, quantity)";
    private String addThings = "insert into " + table + " values (?, ?)";
    private String selectAll = "select * from things";
    private ConnectDB connectDB;
    private Statement statement;
    private PreparedStatement preparedStatement;
    //Constructor
    public ManipulationDB(){
        createConnect();
    }

    //Function
    public void createConnect(){
        connectDB = new ConnectDB();
    }

    public void addThingsToDB (Thing thing){
        try {
            preparedStatement = connectDB.getConnection().prepareStatement(addThings);
            preparedStatement.setString(1, thing.getNameThing());
            preparedStatement.setInt(2, thing.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet selectThingsFromDB () throws SQLException {
        statement = connectDB.getConnection().createStatement();
        return statement.executeQuery(selectAll);
    }
    public ArrayList getThingFromResultSet (ResultSet resultSet) throws SQLException {
        ArrayList <Thing> list = null;
        while (resultSet.next()){
            list.add(new Thing(resultSet.getString(2), resultSet.getInt(3)));
        }
        return  list;
    }

}
