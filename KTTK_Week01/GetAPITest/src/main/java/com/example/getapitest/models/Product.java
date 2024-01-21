package com.example.getapitest.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String product_name;

    @OneToOne
    private Users users;

    public Product(long id, String product_name) {
        this.id = id;
        this.product_name = product_name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + product_name + '\'' +
                ", users=" + users +
                '}';
    }
}
