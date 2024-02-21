package uptc.edu.co.luispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.luispinto.entities.Customer;
import uptc.edu.co.luispinto.response.ResponseHandler;
import uptc.edu.co.luispinto.services.CustomerService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Customer> list = customerService.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService.save(customer);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, savedCustomer);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Customer customer = customerService.findById(id);
            if (customer != null) {
                customerService.delete(customer);
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, customer);
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }
}
