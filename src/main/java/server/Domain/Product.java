package server.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    private @Id
    @GeneratedValue int productNumber;
    public String date;

    @Transient
    public List<Animal> animals;

    public Product() {
    }

    public Product(String date, List<Animal> animals) {
        this.date = date;
        this.animals = animals;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getDate() {
        return date;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

}
