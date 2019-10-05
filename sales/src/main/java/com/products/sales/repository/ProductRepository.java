package com.products.sales.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.products.sales.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {

	
}
