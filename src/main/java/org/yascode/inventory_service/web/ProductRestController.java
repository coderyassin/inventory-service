package org.yascode.inventory_service.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yascode.inventory_service.entity.Product;
import org.yascode.inventory_service.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    private ProductRepository productRepository;

    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Product> productList(){
        return productRepository.findAll();
    }
    @GetMapping("/{id}")
    public Product productById(@PathVariable String id){
        return productRepository.findById(id).get();
    }

}
