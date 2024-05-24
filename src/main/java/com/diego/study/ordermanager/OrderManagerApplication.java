package com.diego.study.ordermanager;

import com.diego.study.ordermanager.model.Category;
import com.diego.study.ordermanager.model.Product;
import com.diego.study.ordermanager.repository.CategoryRepository;
import com.diego.study.ordermanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class OrderManagerApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(OrderManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "IT");
		Category category2 = new Category(null, "Sales");

		Product product1 = new Product(null, "Laptop", BigDecimal.valueOf(3000.00));
		Product product2 = new Product(null, "Chair", BigDecimal.valueOf(700.00));
		Product product3 = new Product(null, "Printer", BigDecimal.valueOf(300.00));

		category1.getProducts().addAll(List.of(product1, product3));
		category2.getProducts().addAll(List.of(product1, product2, product3));

		product1.getCategories().addAll(List.of(category1, category2));
		product2.getCategories().add(category2);
		product3.getCategories().addAll(List.of(category1, category2));

		categoryRepository.saveAll(List.of(category1, category2));
		productRepository.saveAll(List.of(product1, product2, product3));
	}
}
