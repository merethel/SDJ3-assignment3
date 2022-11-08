package server.Domain;

import com.google.protobuf.Message;

public class AnimalAssembler {

    public static Animal fromMessageToAnimal(animals.Animal animalToAssemble){
        Animal animal = new Animal(
                (int) animalToAssemble.getWeight(),
                animalToAssemble.getDate(),
                animalToAssemble.getOrigin()
        );
        return animal;
    }

    public static animals.Animal fromAnimalToMessage(Animal animal){
        animals.Animal message = animals.Animal.newBuilder()
                .setId(animal.getRegistrationNumber())
                .setWeight(animal.getWeight())
                .setOrigin(animal.getOrigin())
                .setDate(animal.getDate())
                .build();

        return message;
    }
}
