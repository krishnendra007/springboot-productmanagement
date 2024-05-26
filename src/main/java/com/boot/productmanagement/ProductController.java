package com.boot.productmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    
    @Autowired
    ProductService service;

    //Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProduct();
    }

    //Get product by ID
    @GetMapping("/product/{id}")
    public Product getProductById (@PathVariable("id") int id){
        return service.getProduct(id);
    }

    //Get product by name
    @GetMapping("/productbyname/{name}")
    public Product getProductbyName (@PathVariable("name") String name){
        return service.getProduct(name);
    }

    //Edit product
    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product p,@PathVariable("id") int id){
        return service.updateProduct(p,id);
    }

    //Add product
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product p){
        return service.addProduct(p);
    }

    //Delete product
    @DeleteMapping("/product/{id}")
    public Product deleteProduct (@PathVariable("id") int id){
        return service.deleteProduct(id);
    }




}
