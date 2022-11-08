package server.Domain;

import animals.AnimalMessage;
import com.google.protobuf.Message;

public class AnimalAssembler {

    public static Animal fromMessageToAnimal(AnimalMessage animalToAssemble){
        Animal animal = new Animal(
                (int) animalToAssemble.getWeight(),
                animalToAssemble.getDate(),
                animalToAssemble.getOrigin()
        );
        return animal;
    }

    public static AnimalMessage fromAnimalToMessage(Animal animal){
        AnimalMessage message = AnimalMessage.newBuilder()
                .setId(animal.getRegistrationNumber())
                .setWeight(animal.getWeight())
                .setOrigin(animal.getOrigin())
                .setDate(animal.getDate())
                .build();

        return message;
    }
}
