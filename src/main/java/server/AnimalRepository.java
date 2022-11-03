package server;

import org.springframework.data.jpa.repository.JpaRepository;
import shared.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
}
