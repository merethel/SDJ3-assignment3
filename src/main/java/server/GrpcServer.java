package server;

import animals.*;
import io.grpc.stub.StreamObserver;
import server.Domain.Animal;
import server.Domain.AnimalAssembler;

import java.util.List;

public class GrpcServer extends AnimalHandlerGrpc.AnimalHandlerImplBase {

    Container container = new Container();
    @Override
    public void getAnimalsInvolved(RequestAnimalsByProductId id, StreamObserver<AnimalReply> responseObserver) {
        List<animals.Animal> animalsToReturn = null;

        for (server.Domain.Product product:container.getProductRepository().findAll().stream().toList()) {
            if (product.getProductNumber() == id.getId()){ //jajajaja for-loop i for-loop :))))
                for (Animal animal:product.getAnimals()){
                    animalsToReturn.add(AnimalAssembler.fromAnimalToMessage(animal));
                }
            }
        }

        AnimalReply reply = AnimalReply.newBuilder().addAllAnimals(animalsToReturn).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }


    @Override
    public void getProductsInvolved(RequestProductsByAnimalId request, StreamObserver<ProductReply> responseObserver) {
        getProductsInvolved(request, responseObserver);
    }
}
