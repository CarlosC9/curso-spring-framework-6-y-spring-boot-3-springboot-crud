package com.carlos.curso.springboot.app.springbootcrud.controllers;

import com.carlos.curso.springboot.app.springbootcrud.entities.Product;
import com.carlos.curso.springboot.app.springbootcrud.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private ProductService productService;

  @GetMapping
  public List<Product> list() {
    return this.productService.findAll();
  }

  @Autowired
  public void setProductService(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> view(
    @PathVariable Long id
  ) {
    Optional<Product> productOptional = this.productService.findById(id);

    if (productOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", 404));
    }

    return ResponseEntity.status(HttpStatus.OK).body(productOptional.orElseThrow());
  }

  @PostMapping
  public ResponseEntity<Product> create(
    @Valid @RequestBody Product product
  ) {
    Product newProduct = this.productService.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(
    @PathVariable Long id,
    @Valid @RequestBody Product product
  ) {
    Optional<Product> optionalProduct = this.productService.update(id, product);

    if (optionalProduct.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", 404));
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(optionalProduct.orElseThrow());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(
    @PathVariable Long id
  ) {
    Product product = new Product();
    product.setId(id);
    Optional<Product> productOptional = this.productService.remove(id);
    if (productOptional.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("status", 404));
    }

    return ResponseEntity.status(HttpStatus.OK).body(productOptional.orElseThrow());
  }
}
