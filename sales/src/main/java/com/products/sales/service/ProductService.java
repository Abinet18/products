package com.products.sales.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.products.sales.model.Product;
@Service
public interface ProductService {

	List<Product> getProducts();
	Optional<Product> getProduct(Long id);
	Product createProduct(Product p);
	Product updateProduct(Product p);
	Long deleteProduct(Long id);
}
