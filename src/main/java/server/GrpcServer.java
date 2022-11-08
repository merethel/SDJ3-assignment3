package server;

import animals.*;
import io.grpc.stub.StreamObserver;
import org.hibernate.SessionFactory;
import server.Domain.Animal;
import server.Domain.AnimalAssembler;
import server.Domain.Product;

import java.util.List;

public class GrpcServer extends AnimalHandlerGrpc.AnimalHandlerImplBase {

    private final SessionFactory sessionFactory;

    public GrpcServer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void getAnimalsInvolved(RequestAnimalsByProductId id, StreamObserver<AnimalReply> responseObserver) {

    }


    @Override
    public void getProductsInvolved(RequestProductsByAnimalId request, StreamObserver<ProductReply> responseObserver) {
    }
}
