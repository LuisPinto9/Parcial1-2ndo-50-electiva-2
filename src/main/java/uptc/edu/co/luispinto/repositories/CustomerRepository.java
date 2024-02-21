package uptc.edu.co.luispinto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uptc.edu.co.luispinto.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
