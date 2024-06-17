package com.product.ProductManagementServices;

import com.product.ProductManagementServices.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDB extends JpaRepository<Products, Integer> {
    Products findByName(String name);
}