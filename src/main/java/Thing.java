public class Thing
{
    //Field
    private int ID;
    private String nameThing;
    private int quantity;

    //Constructor

    public Thing(String nameThing, int quantity) {
        this.nameThing = nameThing;
        this.quantity = quantity;
    }

    //Function


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public String getNameThing() {
        return nameThing;
    }

    public int getQuantity() {
        return quantity;
    }
}
