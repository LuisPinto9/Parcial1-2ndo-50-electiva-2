package uptc.edu.co.luispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.luispinto.entities.Customer;
import uptc.edu.co.luispinto.entities.Product;
import uptc.edu.co.luispinto.entities.Sale;
import uptc.edu.co.luispinto.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save (Product product){
        return productRepository.save(product);
    }
}
