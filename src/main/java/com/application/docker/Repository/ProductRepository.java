package com.application.docker.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.docker.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    @Query(value = "SELECT * FROM product_inventory WHERE product_name = ?1", nativeQuery = true)
    List<Product> getProductsByName(String productName);
}
