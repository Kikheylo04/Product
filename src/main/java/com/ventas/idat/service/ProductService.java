package com.ventas.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventas.idat.model.Product;
import com.ventas.idat.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(String id, Product product) {
        Product productDB = getById(id);
        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        productDB.setStock(product.getStock());
        return repository.save(productDB);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
