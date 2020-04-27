package frontend;

import dao.ConnectDB;
import logic.Thing;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();
    private ConnectDB connectDB = ConnectDB.getConnectDB();
    private List <Thing> listThing = new ArrayList<>();

    public static Model getInstance() {
        return instance;
    }

    private Model() {
    }

    public void addThing(Thing thing) {
        connectDB.insertThingDB(thing);
    }


    public List <Thing> getListThing (){
        return connectDB.selectFromDB();
    }

}
