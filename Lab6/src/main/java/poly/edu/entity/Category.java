package poly.edu.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}


