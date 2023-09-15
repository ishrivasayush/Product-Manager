package com.Narainox.productmanagerapi.Service;

import com.Narainox.productmanagerapi.Model.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);

    List<Product> getAllproduct();

    public Product updateProduct(Integer id,Product pro);
    public Product deleteProductById(Integer id);

    public Product getProductById(Integer id);

    Product getProductByName(String name);
}
