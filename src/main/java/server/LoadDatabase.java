package server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import server.Domain.Animal;
import server.Domain.Product;

import java.util.ArrayList;
import java.util.List;

public class LoadDatabase {
    public static void initDatabase(SessionFactory sessionFactory) {


        //Session - Temporary connection to database. fx handles transactions.
        Session session = sessionFactory.openSession();

        Animal animal1 = new Animal(44, "Januar", "Norskerland");
        Animal animal2 = new Animal(12, "Februar", "Svenskerland");

        List<Animal> animals = new ArrayList<>();
        animals.add(animal1);
        animals.add(animal2);


        Product product1 = new Product("Norskerland", animals);



        session.beginTransaction();
        session.save(animal1);
        session.save(animal2);
        session.save(product1);
        session.getTransaction().commit();
        session.close();
    }
}
