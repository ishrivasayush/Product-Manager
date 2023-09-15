package com.Narainox.productmanagerapi.Controller;

import com.Narainox.productmanagerapi.Model.Product;
import com.Narainox.productmanagerapi.Service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    //http://localhost:8080/product
    @PostMapping("/product")
    public ResponseEntity<Product> registerProductHandler(@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    // http://localhost:8080/product
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProductHandler()
    {
        return new ResponseEntity<>(productService.getAllproduct(),HttpStatus.FOUND);
    }

    // http://localhost:8080/product/1
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductHandler(@PathVariable Integer id)
    {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.FOUND);
    }

    // http://localhost:8080/product/1
    @DeleteMapping("/product/{id}")
    public ResponseEntity<Product> deleteProductHandler(@PathVariable Integer id)
    {
        return new ResponseEntity<>(productService.deleteProductById(id),HttpStatus.OK);
    }

    // http://localhost:8080/product/1
    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProductHandler(@PathVariable Integer id,@RequestBody Product product)
    {
        return new ResponseEntity<>(productService.updateProduct(id,product),HttpStatus.OK);
    }

    // http://localhost:8080/products/Apple iPhone 12 (128GB) - Black
    @GetMapping("/products/{name}")
    public ResponseEntity<Product> getProductHandler(@PathVariable String name)
    {
        return new ResponseEntity<>(productService.getProductByName(name),HttpStatus.FOUND);
    }

}
