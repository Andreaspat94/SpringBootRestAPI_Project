package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {

	Product getProductByPcode(int pcode);
	
	List<Product> getAll();
	
	Product save(Product product); 
	
	void delete(Product product);
	
	List<Product> getAllProductsOrderedByName();
	
	List<Product> getAllProductsOrderedByPriceAsc();
	
	List<Product> getAllProductsOrderedByPriceDesc();
	
	public List<Product> getAllProductsOrderedByPcode();
	
	
}
