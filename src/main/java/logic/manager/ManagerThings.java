package logic.manager;

import logic.Thing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ManagerThings {
    //Field

    //Constructor

    //Function
    public static void main(String[] args) {
        //sessionExample();
        jpaExample();
    }

    private static void jpaExample() {
        Map properties;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Thing thing = new Thing("Meat", 2, 1);
        em.persist(thing);
        em.getTransaction().commit();

        em = emf.createEntityManager();
        List list = em.createQuery("from Thing").getResultList();
        list.forEach(p -> System.out.println(p));
        em.close();
    }

    private static void sessionExample() {
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
