package uptc.edu.co.luispinto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    public Sale() {
    }

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSale;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "fk_customers_sales"))
    @JsonIgnore
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "sales_products",
            joinColumns = @JoinColumn(name = "idSale"),
            inverseJoinColumns = @JoinColumn(name = "idProduct")
    )
    @JsonIgnore
    private List<Product> products;

    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
