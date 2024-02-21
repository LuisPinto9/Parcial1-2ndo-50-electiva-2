package uptc.edu.co.luispinto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uptc.edu.co.luispinto.entities.Customer;
import uptc.edu.co.luispinto.entities.Sale;
import uptc.edu.co.luispinto.response.ResponseHandler;
import uptc.edu.co.luispinto.services.CustomerService;
import uptc.edu.co.luispinto.services.SaleService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService SaleService;

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Sale> list = SaleService.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Sale Sale, @PathVariable Integer id) {
        try {
            Customer customer = customerService.findById(id);
            if (customer != null) {
                Sale result = SaleService.save(Sale, customer);
                return ResponseHandler.generateResponse("Succes", HttpStatus.OK, result);
            } else {
                return ResponseHandler.generateResponse("Succes", HttpStatus.NOT_FOUND, null);
            }
        } catch (Error e) {
            return ResponseHandler.generateResponse("Succes", HttpStatus.INTERNAL_SERVER_ERROR, e);

        }
    }


}
