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
        if (validate(sale.getProducts())) {
            sale.setCustomer(customer);
            updateProduct(sale.getProducts());
            return saleRepository.save(sale);
        } else {
            return null;
        }
    }

    public boolean validate(List<Product> products) {
        for (Product product : products) {
            if (product.getStock() == 0){
                return false;
            } else {
                Product storedProduct = productService.findById(product.getIdProduct());
                if (storedProduct != null && product.getStock() > storedProduct.getStock()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void updateProduct(List<Product> products) {
        for (Product product : products) {
            Product productFound = productService.findById(product.getIdProduct());
            if (productFound != null) {
                int updatedStock = productFound.getStock() - product.getStock();
                if (updatedStock >= 0) {
                    productFound.setStock(updatedStock);
                    productRepository.save(productFound);
                }
            }
        }
    }
}
