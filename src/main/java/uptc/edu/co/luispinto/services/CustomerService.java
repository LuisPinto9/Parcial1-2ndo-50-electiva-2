package uptc.edu.co.luispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.luispinto.entities.Customer;
import uptc.edu.co.luispinto.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }
}
