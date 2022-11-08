package server;

import animals.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import server.Domain.Animal;

import java.util.ArrayList;
import java.util.List;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AnimalRepository animalRepository, ProductRepository productRepository){
        return args -> {
            animalRepository.save(new server.Domain.Animal(55, "januar", "DanskerLand"));
            animalRepository.save(new server.Domain.Animal(55, "februar", "SvenskerLand"));
            animalRepository.save(new server.Domain.Animal(25, "marts", "FinskerLand"));


            List<Animal> animals1 = new ArrayList<>();
            animals1.add(getAnimalById(animalRepository.findAll(), 1));
            animals1.add(getAnimalById(animalRepository.findAll(), 2));

            List<Animal> animals2 = new ArrayList<>();
            animals2.add(getAnimalById(animalRepository.findAll(), 2));
            animals2.add(getAnimalById(animalRepository.findAll(), 3));

            List<Animal> animals3 = new ArrayList<>();
            animals3.add(getAnimalById(animalRepository.findAll(), 1));
            animals3.add(getAnimalById(animalRepository.findAll(), 3));

            productRepository.save(new server.Domain.Product
                    ("jul", animals1));

            productRepository.save(new server.Domain.Product
                    ("nytår", animals2));

            productRepository.save(new server.Domain.Product
                    ("påske", animals3));


            animalRepository.findAll().forEach(animal -> log.info("Preloaded " + animal));
            productRepository.findAll().forEach(product -> log.info("Preloaded " + product));
        };
    }

    private Animal getAnimalById(List<server.Domain.Animal> animals, int id){
        for (server.Domain.Animal animal:animals) {
            if (animal.getRegistrationNumber() == id){
                return animal;
            }
        }
        return null;
    }
}

