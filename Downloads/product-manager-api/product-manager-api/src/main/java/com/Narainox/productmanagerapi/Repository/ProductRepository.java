package com.Narainox.productmanagerapi.Repository;

import com.Narainox.productmanagerapi.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Optional<Product> findByProductName(String name);
}
