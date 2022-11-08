package client;

import animals.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public GrpcClient() {

    }
    public AnimalReply involvedAnimals(int id){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        AnimalHandlerGrpc.AnimalHandlerBlockingStub animalStub = AnimalHandlerGrpc
                .newBlockingStub(managedChannel);

        RequestAnimalsByProductId request = RequestAnimalsByProductId.newBuilder().setId(id).build();
        AnimalReply reply = animalStub.getAnimalsInvolved(request);
        managedChannel.shutdown();

        return reply;
    }

    public ProductReply productsInvolvedIn(int id){
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();

        AnimalHandlerGrpc.AnimalHandlerBlockingStub animalStub = AnimalHandlerGrpc
                .newBlockingStub(managedChannel);

        RequestProductsByAnimalId request = RequestProductsByAnimalId.newBuilder().setId(id).build();
        ProductReply reply = animalStub.getProductsInvolved(request);
        managedChannel.shutdown();

        return reply;
    }


}
