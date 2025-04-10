package com.application.docker.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.docker.Model.Product;
import com.application.docker.Repository.ProductRepository;

@Service
public class ProductService 
{
    @Autowired 
    private ProductRepository productRepository;

    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    public Product getProduct(long productId)
    {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public List<Product> getProducts()
    {
        return productRepository.findAll();
    }

    public Product updateProduct(long productId, Product product)
    {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        existingProduct.setProductName(product.getProductName());
        existingProduct.setColor(product.getColor());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
        return existingProduct;
    }

    public Product deleteproduct(long productId) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Not Found"));
        productRepository.deleteById(productId);
        return existingProduct;
    }
 
 
    public List<Product> getProductsByName(String productName) {
        return productRepository.getProductsByName(productName);
    }
}
