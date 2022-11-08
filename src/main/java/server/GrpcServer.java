package server;

import animals.*;
import io.grpc.stub.StreamObserver;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import server.Domain.Animal;
import server.Domain.AnimalAssembler;
import server.Domain.Product;
import server.Domain.ProductAssembler;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class GrpcServer extends AnimalHandlerGrpc.AnimalHandlerImplBase {

    private final SessionFactory sessionFactory;

    public GrpcServer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void getAnimalsInvolved(RequestAnimalsByProductId id, StreamObserver<AnimalReply> responseObserver) {
        List<AnimalMessage> animals = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class, id.getId());

        for (Animal animal : product.getAnimals()) {
            animals.add(AnimalAssembler.fromAnimalToMessage(animal));
        }

        session.close();
        AnimalReply reply = AnimalReply.newBuilder().addAllAnimals(animals).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    @Override
    public void getProductsInvolved(RequestProductsByAnimalId request, StreamObserver<ProductReply> responseObserver) {
        List<ProductMessage> products = new ArrayList<>();

        Session session = sessionFactory.openSession();
        Animal animal = session.get(Animal.class, request.getId());
        for (Product product : animal.getProducts()) {
            products.add(ProductAssembler.fromProductToMessage(product));
        }

        session.close();
        ProductReply reply = ProductReply.newBuilder().addAllProducts(products).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
