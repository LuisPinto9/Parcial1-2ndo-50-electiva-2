package uptc.edu.co.luispinto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    public Product() {
    }

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProduct;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Integer stock;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sale> sales;

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}
