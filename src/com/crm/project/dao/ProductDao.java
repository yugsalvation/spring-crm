package com.crm.project.dao;

import java.util.List;

import com.crm.project.entity.Product;


public interface ProductDao {
	public Product getProduct(String pid);
	public List<Product> getProducts();
}
