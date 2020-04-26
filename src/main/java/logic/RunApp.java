package logic;

import dao.ManipulationDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RunApp {
    //Field

    private ManipulationDB manipulationDB;

    //Constructor


    //Function
    public void run() throws SQLException {
        manipulationDB = new ManipulationDB();
        manipulationDB.createConnect();
        //manipulationDB.addThingsToDB(new Thing("s", 2));
        ResultSet resultSet = manipulationDB.selectThingsFromDB();
        while (resultSet.next()){
            System.out.print(resultSet.getInt(1) + " ");
            System.out.print(resultSet.getString(2));
            System.out.println(resultSet.getInt(3));
        }
    }



}
