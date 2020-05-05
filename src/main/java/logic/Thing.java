package logic;

import frontend.DateAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.time.LocalDate;

public class Thing
{
    //Field
    private int ID;
    private String nameThing;
    private int quantity;
    @XmlJavaTypeAdapter(value = DateAdapter.class)
    private Date addThingDate;

    //Constructor

    public Thing (){

    }
    public Thing(String nameThing, int quantity) {
        this.nameThing = nameThing;
        this.quantity = quantity;
        this.addThingDate = Date.valueOf(LocalDate.now());
    }

    //Function


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameThing() {
        return nameThing;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setNameThing(String nameThing) {
        this.nameThing = nameThing;
    }

    public Date getAddThingDate() {
        return addThingDate;
    }

    public void setAddThingDate(Date addThingDate) {
        this.addThingDate = addThingDate;
    }
}
