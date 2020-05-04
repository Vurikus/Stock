package frontend;

import dao.SimpleConnection;
import logic.Thing;
import logic.user.User;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();
    private SimpleConnection simpleConnection;
    private List <Thing> listThing = new ArrayList<>();
    private List <User> listUser = new ArrayList<>();

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        //addUser(new User ("ivan", "email", "123"));
    }

    public void addThing(Thing thing) {
        simpleConnection.insertThingDB(thing);
    }

    public SimpleConnection getSimpleConnection() {
        return simpleConnection;
    }

    public void setSimpleConnection(SimpleConnection simpleConnection) {
        this.simpleConnection = simpleConnection;
    }

    public List <Thing> getListThing (){
        return simpleConnection.selectFromDB();
    }

    public void addUser (User user){
        listUser.add(user);
    }

    public List<User> getListUser() {
        return listUser;
    }
}
