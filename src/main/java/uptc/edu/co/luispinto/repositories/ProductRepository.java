package uptc.edu.co.luispinto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.co.luispinto.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
