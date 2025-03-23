package com.karan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.karan.model.Product;
import com.karan.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {
    @Autowired
    private ProductService pService;

    // POST MAPPING
    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product p) {
        String msg = "Product added Successfully";
        pService.addProduct(p);
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }

    // GET MAPPING (for all)
    @GetMapping("/fetch")
    public ResponseEntity<List<Product>> getProduct() {
        List<Product> pList = pService.getProduct();
        return new ResponseEntity<List<Product>>(pList, HttpStatus.OK);
    }

    // GET MAPPING (for only one through id)
    @GetMapping("/fetch/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product p = pService.getProductById(id);
        return new ResponseEntity<Product>(p, HttpStatus.OK);
    }

    // DELETE MAPPING
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        pService.deleteProduct(id);
        String msg = "Product Deleted Successfully";
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    // PUT MAPPING
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        Product p = pService.updateProduct(id, product);
        String msg = "";
        if (p != null) {
            msg = "Product Updated";
        } else {
            msg = "Product not Updated";
        }
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    // Searching
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword){
        List<Product> plist = pService.searchProduct(keyword);
        return new ResponseEntity<List<Product>>(plist, HttpStatus.OK);
    }
}
