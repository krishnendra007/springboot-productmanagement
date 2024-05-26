package com.boot.productmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductDB db;

    //Getting all products
    public List<Product> getAllProduct() {
       return db.findAll();
    }

    //get product by ID
    public Product getProduct(int id) {
      return db.findById(id).orElse(null);
      
    }

    //get product by name
    public Product getProduct(String name) {
        return db.findByName(name);
    }

    //Add product 
    public Product addProduct(Product p) {
      db.save(p);
      return p;
    }

    
    //Update product
    public Product updateProduct(Product updatedP, int id) {
      Product p = db.findById(id).orElse(null);
      if(updatedP.getName()!=null )p.setName(updatedP.getName());
      if(updatedP.getPlace()!=null )p.setPlace(updatedP.getPlace());
      if(updatedP.getWarrenty()!=0)p.setWarrenty(updatedP.getWarrenty());
      if(updatedP.getType()!=null )p.setType(updatedP.getType());
      db.save(p);
      return p;
    }

    //Delet product
    public Product deleteProduct(int id) {
      Product p = db.findById(id).orElse(null);
      db.deleteById(id);
      return p;
    }



   
    // public List<Product> getProductByText(String string) {
    //     List<Product> p = new ArrayList<>();

    //     for( Product pr : products){
    //         if(pr.getName().contains(string)||pr.getPlace().contains(string)||pr.getType().contains(string)){
    //             p.add(pr);
    //         }
    //     }
    //     return p;
    // }
    
}
