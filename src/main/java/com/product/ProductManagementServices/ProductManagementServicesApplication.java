package com.product.ProductManagementServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class ProductManagementServicesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProductManagementServicesApplication.class, args);

		ProductService service = context.getBean(ProductService.class);

		List<Products> products = service.getAllProducts();

		for(Products p : products){
			System.out.println(p);
		}
	}

}
