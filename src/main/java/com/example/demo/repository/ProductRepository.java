package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
		
	Product findByPcode(int pcode);
	
	List<Product> findAllByOrderByPname();
	
	List<Product> findAllByOrderByPprice();
	
	List<Product> findAllByOrderByPpriceDesc();
	
	List<Product> findAllByOrderByPcode();
	

}
