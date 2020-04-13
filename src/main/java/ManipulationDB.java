import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ManipulationDB {
    //Field
    private String table = "things (nameThing, quantity)";
    private String addThings = "insert into " + table + " values (?, ?)";
    private String selectAll = "select * from things";
    private ConnectDB connectDB;
    private Statement statement;
    private PreparedStatement preparedStatement;
    //Constructor

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

    public void selectThingsFromDB (){
        try {
            statement = connectDB.getConnection().createStatement();
            statement.executeQuery(selectAll);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
