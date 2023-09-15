package com.Narainox.productmanagerapi.Model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "products")
@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String productName;
    private Double price;
    private String description;
    private String status;
}
