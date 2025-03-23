package com.karan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karan.model.Product;
import com.karan.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository prepo;

    public void addProduct(Product p) {
        prepo.save(p);
    }

    public List<Product> getProduct() {
        return prepo.findAll();
    }

    public Product getProductById(Integer id) {
        return prepo.findById(id).orElse(null);
    }

    public void deleteProduct(Integer id) {
        Product p = prepo.findById(id).orElse(null);
        if (p != null) {
            prepo.delete(p);
        }
    }

    public Product updateProduct(Integer id, Product product) {
        Product p = prepo.findById(id).orElse(null);
        if (p != null) {

            // ???

            // ?????
            prepo.save(product);
        }
        return p;
    }

    public List<Product> searchProduct(String keyword) {
        return prepo.searchProduct(keyword);
    }
}
