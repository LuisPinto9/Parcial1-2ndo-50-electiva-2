package uptc.edu.co.luispinto.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    public Customer() {
    }

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20, name = "lastname")
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Sale> sale;

    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
