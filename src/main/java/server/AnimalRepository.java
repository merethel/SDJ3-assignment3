package server;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import server.Domain.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{
}



