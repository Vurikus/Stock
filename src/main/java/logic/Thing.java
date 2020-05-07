package logic;

import frontend.DateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "things")
public class Thing
{
    //Field
    @Id
    @Column (name = "thing_id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int ID;

    @Column (name = "thing_name")
    private String nameThing;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "life_time")
    private float lifeTime;

    @Column (name = "date_added")
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

    public Thing(String nameThing, int quantity, float lifeTime) {
        this.nameThing = nameThing;
        this.quantity = quantity;
        this.lifeTime = lifeTime;
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

    public float getLifeTime() {
        return lifeTime;
    }

    public void setLifeTime(float lifeTime) {
        this.lifeTime = lifeTime;
    }

    public Date getAddThingDate() {
        return addThingDate;
    }

    public void setAddThingDate(Date addThingDate) {
        this.addThingDate = addThingDate;
    }
}
