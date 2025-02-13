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

  @Override
  @Transactional
  public Optional<Product> remove(Product product) {
    Optional<Product> productOptional = this.productRepository.findById(product.getId());
    productOptional.ifPresent(productDb -> {
      this.productRepository.delete(productDb);
    });
    return productOptional;
  }

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }
}
