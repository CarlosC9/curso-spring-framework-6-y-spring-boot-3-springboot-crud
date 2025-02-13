package com.carlos.curso.springboot.app.springbootcrud.services;

import com.carlos.curso.springboot.app.springbootcrud.entities.Product;
import com.carlos.curso.springboot.app.springbootcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<Product> findAll() {
    return (List<Product>) this.productRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Product> findById(Long id) {
    return this.productRepository.findById(id);
  }

  @Override
  @Transactional
  public Product save(Product product) {
    return this.productRepository.save(product);
  }

  @Transactional
  @Override
  public Optional<Product> update(Long id, Product product) {
    Optional<Product> productOptional = this.productRepository.findById(id);
    if (productOptional.isPresent()) {
      Product productDb = productOptional.orElseThrow();
      productDb.setName(product.getName());
      productDb.setDescription(product.getDescription());
      productDb.setPrice(product.getPrice());
      return Optional.of(this.productRepository.save(productDb));
    }
    return productOptional;
  }

  @Override
  @Transactional
  public Optional<Product> remove(Long id) {
    Optional<Product> productOptional = this.productRepository.findById(id);
    productOptional.ifPresent(productDb -> {
      this.productRepository.delete(productDb);
    });
    return productOptional;
  }
}
