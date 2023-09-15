package com.Narainox.productmanagerapi.Service;

import com.Narainox.productmanagerapi.Exception.ProductException;
import com.Narainox.productmanagerapi.Model.Product;
import com.Narainox.productmanagerapi.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {
        Product pro = productRepository.save(product);
        return pro;
    }

    @Override
    public List<Product> getAllproduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
        {
            return product.get();
        }
        else {
            throw new ProductException("Product","id",id);
        }
    }

    @Override
    public Product getProductByName(String name) {
        Optional<Product> product = productRepository.findByProductName(name);
        if (product.isPresent())
        {
            return product.get();
        }
        else {
            throw new ProductException("Product","Name",name);
        }
    }

    @Override
    public Product deleteProductById(Integer id)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
        {
            Product pro = product.get();
            productRepository.delete(pro);
            return pro;
        }
        else {
            throw new ProductException("Product","id",id);
        }
    }

    @Override
    public Product updateProduct(Integer id,Product pro)
    {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent())
        {
            Product product1 = product.get();
            product1.setProductName(pro.getProductName());
            product1.setDescription(pro.getDescription());
            product1.setStatus(pro.getStatus());
            product1.setPrice(pro.getPrice());
            productRepository.save(product1);
            return product1;
        }
        else {
            throw new ProductException("Product","id",id);
        }
    }
}
