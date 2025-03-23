package com.karan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.karan.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select p from Product p where " +
            "lower(p.name) like lower(concat('%', :keyword, '%')) or " +
            "lower(p.description) like lower(concat('%', :keyword, '%')) or " +
            "lower(p.brand) like lower(concat('%', :keyword, '%')) or " +
            "lower(p.category) like lower(concat('%', :keyword, '%'))")
    List<Product> searchProduct(String keyword);

}
