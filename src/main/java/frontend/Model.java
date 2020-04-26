package frontend;

import logic.Thing;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static Model instance = new Model();

    private List<Thing> modelList;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        modelList = new ArrayList<>();
    }

    public void add(Thing thing) {
        modelList.add(thing);
    }

    public List<Thing> getList() {
        return modelList;
    }
}
