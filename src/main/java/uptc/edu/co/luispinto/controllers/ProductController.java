package uptc.edu.co.luispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.luispinto.entities.Product;
import uptc.edu.co.luispinto.response.ResponseHandler;
import uptc.edu.co.luispinto.services.ProductService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService ProductService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Product> list = ProductService.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Product Product) {
        try {
            Product savedProduct = ProductService.save(Product);
            if (savedProduct == null) {
                return ResponseHandler.generateResponse("Error", HttpStatus.BAD_REQUEST, savedProduct);
            } else {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, savedProduct);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

}
