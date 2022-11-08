package server.Domain;

import animals.AnimalMessage;
import animals.ProductMessage;
import java.util.List;

public class ProductAssembler {

    public static Product fromMessageToProduct(ProductMessage productToAssemble){
        List<Animal> animals = null;

        for (AnimalMessage animalMessage:productToAssemble.getAnimalIdsList()) {
            Animal animal = AnimalAssembler.fromMessageToAnimal(animalMessage);
            animals.add(animal);
        }


        Product product = new Product(
                productToAssemble.getDate(),
                animals
        );
        return product;
    }

    public static ProductMessage fromProductToMessage(Product product){
            List<AnimalMessage> animalList = null;

            for (Animal animal: product.getAnimals()) {
                AnimalMessage animalMessage = AnimalAssembler.fromAnimalToMessage(animal);
                animalList.add(animalMessage);
            }

            ProductMessage message = ProductMessage.newBuilder()
                .setId(product.getProductNumber())
                .setDate(product.getDate())
                .addAllAnimalIds(animalList).build();

        return message;
    }

}
