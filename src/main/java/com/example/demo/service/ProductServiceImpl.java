package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

	//This method is called in the update endpoint of the controller
	public void updateProduct(Product product, Product currentProduct) {
		currentProduct.setPname(product.getPname());
		currentProduct.setPprice(product.getPprice());
		currentProduct.setPcode(product.getPcode());
		currentProduct.setExpdate(product.getExpdate());
		currentProduct.setAvaildate(product.getAvaildate());
	
		productRepo.save(currentProduct);
	}
	
	//This method is used for retrieving the appropriate data for the "getProducts" entity
	public List<Product> getProducts(String param, boolean asc) {
		String value = param;
		switch(value) {
			case "name":
				return getAllProductsOrderedByName();
			case "price":
				if(asc) {
					return getAllProductsOrderedByPriceAsc();
				} else {
					return getAllProductsOrderedByPriceDesc();
				}
			case "code":
				return getAllProductsOrderedByPcode();
			case "id":
				return getAll();
			default:
				return null;
				
		}
		
	}
	
}