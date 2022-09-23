package com.spring.main.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.main.db.ProductDB;
import com.spring.main.model.Product;

@Service
public class Productservice {

	@Autowired
	private ProductDB productdb;

	public List<Product> fetchAllProducts() {
		List<Product> list = productdb.fetchAllProducts();
		return list;
	}

	public void insertProduct(Product product) {
		productdb.insertProduct(product);

	}

	public void deleteProduct(Integer id) {
		productdb.deleteProduct(id);

	}

	public void processedit(Product product) {
		productdb.processedit(product);

	}
}
