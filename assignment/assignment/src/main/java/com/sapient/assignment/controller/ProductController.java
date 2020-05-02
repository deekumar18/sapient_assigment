package com.sapient.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.assignment.domain.Product;
import com.sapient.assignment.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService prodService;

	@GetMapping("/product/{pid}")
	public Product getOneProdInfo(@PathVariable("pid") String pid) {

		return prodService.getProductInfoById(pid);
	}

	@GetMapping("/products")
	public List<Product> getAllProdInfo() {

		return prodService.getAllProd();
	}

	//public addProduct()
	/*
	 * 1. Group by brand / client 2. Group by price 3. Group by Color 4. Group by
	 * Size 5. Get by SKU
	 */
	

	@GetMapping("/products/{groupByClause}")
	public Map<String, List<Product>> getProdInfoByFilter(@PathVariable("groupByClause") String groupByClause) {

		return prodService.getProductInfoByGroupByClouse(groupByClause);
	}
	
}
