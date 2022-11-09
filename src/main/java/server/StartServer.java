package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import server.Domain.Animal;
import server.Domain.Product;

import java.util.Scanner;

public class StartServer {
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);


        Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure("hibernate.cfg.xml");

        System.out.println("Please input your password to your local postgreSQL Database");
        configuration.setProperty("hibernate.connection.password", keyboard.nextLine());
        configuration.addAnnotatedClass(Animal.class);
        configuration.addAnnotatedClass(Product.class);


        //Session factory - Creates temporary connections to the database (aka sessions)

        SessionFactory sessionFactory = configuration.buildSessionFactory();




        //IMPORTANT, run this line only to populate the datebase.
        //LoadDatabase.initDatabase(sessionFactory);

        Server server = ServerBuilder.forPort(9090).addService(new GrpcServer(sessionFactory)).build();
        server.start();
        server.awaitTermination();

    }
}
