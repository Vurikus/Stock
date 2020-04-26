import logic.RunApp;

import java.sql.SQLException;

public class Main
{
    //Field

    //Constructor

    //Function
    public static void main(String[] args) {
        try {
            (new RunApp()).run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
