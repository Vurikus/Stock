package logic.manager;

import logic.Thing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Date;
import java.time.LocalDate;

public class ManagerThings {
    //Field

    //Constructor

    //Function
    public static void main(String[] args) {
        SessionFactory sf = buildSessionFactory();
        Session session = sf.openSession();
        session.getTransaction().begin();
        Thing thing = new Thing();
        thing.setNameThing("Snikers");
        thing.setQuantity(2);
        thing.setLifeTime(3);
        thing.setAddThingDate(Date.valueOf(LocalDate.now()));
        session.save(thing);
        System.out.println(session.save(thing));
        session.getTransaction().commit();
        session.close();
    }

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        return sessionFactory;
    }
}
