package server;

import animals.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.Domain.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
}
