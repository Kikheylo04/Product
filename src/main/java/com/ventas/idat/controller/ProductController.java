package com.ventas.idat.controller;

import com.ventas.idat.dto.ProductDTO;
import com.ventas.idat.model.Product;
import com.ventas.idat.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
   @Autowired
   public ProductService productService;

   @GetMapping({""})
   public List<Product> listAll() {
      return this.productService.listAll();
   }

   @GetMapping({"/{id}"})
   public Product getById(@PathVariable String id) {
      return this.productService.getById(id);
   }

   @PostMapping({""})
   public ResponseEntity<Product> create(@RequestBody @Valid ProductDTO productDto) {
      Product product = this.convertToEntity(productDto);
      Product productSaved = this.productService.save(product);
      return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
   }

   @PutMapping({"/{id}"})
   public Product update(@PathVariable String id, @RequestBody Product product) {
      return this.productService.update(id, product);
   }

   @DeleteMapping({"/{id}"})
   public void delete(@PathVariable String id) {
      this.productService.delete(id);
   }

   private Product convertToEntity(ProductDTO dto) {
      Product product = new Product();
      product.setName(dto.getName());
      product.setDescription(dto.getDescription());
      product.setPrice(dto.getPrice());
      product.setStock(dto.getStock());
      return product;
   }
}
