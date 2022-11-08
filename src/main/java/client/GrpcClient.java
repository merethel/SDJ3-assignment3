package client;

import animals.Animal;
import animals.AnimalHandlerGrpc;
import animals.AnimalReply;
import animals.RequestAnimalsByProductId;
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
}
