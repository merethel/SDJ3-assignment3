package client;

public class StartClient {
    public static void main(String[] args) {
        GrpcClient client = new GrpcClient();
        System.out.println(client.involvedAnimals(1).toString());
    }
}
