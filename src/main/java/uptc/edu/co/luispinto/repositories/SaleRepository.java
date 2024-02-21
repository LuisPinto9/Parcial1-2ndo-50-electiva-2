package uptc.edu.co.luispinto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.co.luispinto.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
