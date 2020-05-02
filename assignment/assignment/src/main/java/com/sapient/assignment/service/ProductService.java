package com.sapient.assignment.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.assignment.domain.Product;
import com.sapient.assignment.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository prodRepo;
	
	public Product getProductInfoById(String pid)
	{
		return prodRepo.findById(pid).get();
	}
	
	public List<Product> getAllProd() {
		return prodRepo.findAll();
	}

	public Map<String, List<Product>> getProductInfoByGroupByClouse(String groupByClause) {

		List<Product> lstOfProd = prodRepo.findAll();
		
		if (groupByClause.equalsIgnoreCase("color"))
		{			
			return lstOfProd.stream().collect(Collectors.groupingBy(Product::getColor));
		}
		if (groupByClause.equalsIgnoreCase("size"))
		{			
			return lstOfProd.stream().collect(Collectors.groupingBy(Product::getSize));
		}
		
		
		
		return null;
	}
	
	

}
