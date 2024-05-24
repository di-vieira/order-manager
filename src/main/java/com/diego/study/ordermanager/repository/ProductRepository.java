package com.diego.study.ordermanager.repository;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
