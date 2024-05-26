package com.boot.productmanagement;

import java.util.List;
import java.util.Scanner;

//import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductmanagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductmanagementApplication.class, args);


		//ApplicationContext context= SpringApplication.run(ProductmanagementApplication.class, args);
		// ProductService service=context.getBean(ProductService.class);
		
		// // Find ALL Products
		// List<Product> products= service.getAllProduct();
		// for(Product p: products){
		// 	System.out.println(p);
		// }


		//Find BY Name
		// Product p= service.getProduct("macbook-pro");
		// System.out.println(p);


		//Adding Product
		// Scanner sc = new Scanner(System.in);
		// System.out.println("enter name of product");
		// String name =sc.nextLine();
		// System.out.println("enter Type of product");
		// String type =sc.nextLine();
		// System.out.println("enter place of product");
		// String place =sc.nextLine();
		// System.out.println("enter Warrenty year of product");
		// int warrenty =sc.nextInt();

		// Product p= new Product();
		
		// p.setName(name);
		// p.setType(type);
		// p.setWarrenty(warrenty);
		// p.setPlace(place);
		// Product pr=service.addProduct(p);
		// System.out.println(pr);
		


	}

}
