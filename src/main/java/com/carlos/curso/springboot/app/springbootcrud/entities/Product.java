package com.carlos.curso.springboot.app.springbootcrud.entities;

import com.carlos.curso.springboot.app.springbootcrud.validation.IsExistsDb;
import com.carlos.curso.springboot.app.springbootcrud.validation.IsRequired;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @IsRequired(message = "{IsRequired.product.name}")
  @Size(min=3, max=20)
  private String name;

  @NotNull
  @PositiveOrZero
  private Integer price;

  @IsRequired
  private String description;

  @IsRequired
  @IsExistsDb
  private String sku;

  public Product() {
  }

  public Product(String name, Integer price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  @Override
  public String toString() {
    return "Product{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", price=" + price +
      ", description='" + description + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
