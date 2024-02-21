package uptc.edu.co.luispinto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uptc.edu.co.luispinto.entities.Customer;
import uptc.edu.co.luispinto.entities.Product;
import uptc.edu.co.luispinto.entities.Sale;
import uptc.edu.co.luispinto.repositories.CustomerRepository;
import uptc.edu.co.luispinto.repositories.ProductRepository;
import uptc.edu.co.luispinto.repositories.SaleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale save(Sale sale, Customer customer) {
        sale.setCustomer(customer);
        return saleRepository.save(sale);
    }

    public boolean validate(List<Product> products){
        return true;
    }

    public Product updateProduct(Integer id, Product product) {
        Product productFound = productService.findById(id);
        productFound.setName(product.getName());
        productFound.setStock(product.getStock() - 1);
        productRepository.save(productFound);
        return productFound;
    }

}
