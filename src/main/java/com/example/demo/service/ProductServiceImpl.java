package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public void delete(Product product) {
		productRepo.delete(product);
	}
	
	public Product getProductByPcode(int pcode) {
		return productRepo.findByPcode(pcode);
	}
	
	public List<Product> getAllProductsOrderedByName() {
		return productRepo.findAllByOrderByPname();
	}
	
	public List<Product> getAllProductsOrderedByPriceAsc() {
		return productRepo.findAllByOrderByPprice();
	}
	
	public List<Product> getAllProductsOrderedByPriceDesc() {
		return productRepo.findAllByOrderByPpriceDesc();
	}
	
	public List<Product> getAllProductsOrderedByPcode() {
		return productRepo.findAllByOrderByPcode();
	}

	
}