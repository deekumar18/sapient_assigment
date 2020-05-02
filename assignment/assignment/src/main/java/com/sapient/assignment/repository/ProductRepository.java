package com.sapient.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.assignment.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}
