package org.yascode.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.yascode.inventory_service.entity.Product;
import org.yascode.inventory_service.repository.ProductRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ProductRepository productRepository) {
		return args -> {
			productRepository.save(new Product("1", "Laptop", 1000, 10));
			productRepository.save(new Product("2", "Mobile", 500, 5));
			productRepository.save(new Product("3", "Tablet", 800, 8));
			productRepository.save(new Product("4", "Camera", 600, 6));
		};
	}

}
