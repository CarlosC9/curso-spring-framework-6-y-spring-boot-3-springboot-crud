package com.carlos.curso.springboot.app.springbootcrud.repositories;

import com.carlos.curso.springboot.app.springbootcrud.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
