public class RunApp {
    //Field

    private ManipulationDB manipulationDB;

    //Constructor


    //Function
    public void run(){
        manipulationDB = new ManipulationDB();
        manipulationDB.createConnect();
        manipulationDB.addThingsToDB(new Thing("s", 2));
    }


}
