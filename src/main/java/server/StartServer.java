package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import server.Domain.Animal;
import server.Domain.Product;


@SpringBootApplication
public class StartServer {
    public static void main(String[] args) throws Exception {

        Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Animal.class);
        configuration.addAnnotatedClass(Product.class);


        //Session factory - Creates temporary connections to the database (aka sessions)

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        LoadDatabase.initDatabase(sessionFactory);

        Server server = ServerBuilder.forPort(9090).addService(new GrpcServer(sessionFactory)).build();
        server.start();
        server.awaitTermination();

    }
}
