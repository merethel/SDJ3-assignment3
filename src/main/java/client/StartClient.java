package client;

public class StartClient {
    public static void main(String[] args) {
        GrpcClient client = new GrpcClient();
        System.out.println(client.involvedAnimals(19).toString());
        System.out.println(client.involvedAnimals(20).toString());
        System.out.println(client.involvedAnimals(21).toString());

        System.out.println("------------------------------------------------");
        System.out.println(client.productsInvolvedIn(11));
    }
}
