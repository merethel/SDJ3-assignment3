package server.Domain;

import animals.ProductOrBuilder;

import java.util.List;

public class ProductAssembler {

    public Product fromMessageToProduct(animals.Product productToAssemble){
        List<Animal> animals = null;

        for (animals.Animal animalMessage:productToAssemble.getAnimalIdsList()) {
            Animal animal = AnimalAssembler.fromMessageToAnimal(animalMessage);
            animals.add(animal);
        }


        Product product = new Product(
                productToAssemble.getDate(),
                animals
        );
        return product;
    }

    public animals.Product fromProductToMessage(Product product){
            List<animals.Animal> animalList = null;

            for (Animal animal: product.getAnimals()) {
                animals.Animal animalMessage = AnimalAssembler.fromAnimalToMessage(animal);
                animalList.add(animalMessage);
            }

            animals.Product message = animals.Product.newBuilder()
                .setId(product.getProductNumber())
                .setDate(product.getDate())
                .addAllAnimalIds(animalList).build();

        return message;
    }

}
