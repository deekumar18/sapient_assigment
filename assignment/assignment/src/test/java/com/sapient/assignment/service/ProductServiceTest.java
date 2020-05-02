package com.sapient.assignment.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.assignment.domain.Product;
import com.sapient.assignment.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest<E> {
	
	@MockBean
	ProductRepository prodRepo;
	
	@Autowired
	ProductService prodService;
	
	@Test
	public void getProductInfoByIdTest() {
		
		Product mockObj = new Product(); 
		mockObj.setCid("C001");
		mockObj.setColor("WHITE");
		mockObj.setName("shirt");
		mockObj.setPid("P001");
		mockObj.setPrice(1000);
		mockObj.setSize("M");
		
		String pid ="P001";
		
		Mockito.when(prodRepo.findById(pid).get()).thenReturn(mockObj);
	}
	
	
	
	@Test
	public void getAllProdTest() {
		
		Product mockObj1 = new Product(); 
		mockObj1.setCid("C001");
		mockObj1.setColor("WHITE");
		mockObj1.setName("shirt");
		mockObj1.setPid("P001");
		mockObj1.setPrice(1000);
		mockObj1.setSize("M");
		
		Product mockObj2 = new Product(); 
		mockObj2.setCid("C001");
		mockObj2.setColor("WHITE");
		mockObj2.setName("shirt");
		mockObj2.setPid("P001");
		mockObj2.setPrice(1000);
		mockObj2.setSize("M");
		
		
		
		List<Product> mockList = Stream.of(mockObj1,mockObj2).collect(Collectors.toList());
		
		
		Mockito.when(prodRepo.findAll()).thenReturn(mockList);
		
		
	}
	/*
	 * @Test void getProductInfoByIdTest() {
	 * 
	 * }
	 */
	
	

}
