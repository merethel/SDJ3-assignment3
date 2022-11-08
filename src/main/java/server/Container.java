package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Container {
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private ProductRepository productRepository;

    public AnimalRepository getAnimalRepository() {
        return animalRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }
}
