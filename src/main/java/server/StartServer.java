package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StartServer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Container.class, args);
        Server server = ServerBuilder.forPort(9090).addService(new GrpcServer()).build();
        server.start();
        server.awaitTermination();

    }
}
