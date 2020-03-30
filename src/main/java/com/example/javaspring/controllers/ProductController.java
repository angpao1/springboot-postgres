package com.example.javaspring.controllers;

import com.example.javaspring.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    ArrayList<Product> products = new ArrayList<>();

    @GetMapping(path = "/products")
    public ArrayList<Product> products() {

        Product product1 = new Product();
        product1.setId("1");
        product1.setProductName("acer");
        product1.setPrice("100");
        System.out.println(product1.toString());

        Product product2 = new Product();
        product2.setId("2");
        product2.setProductName("mac");
        product2.setPrice("200");
        System.out.println(product2.toString());

        Product product3 = new Product();
        product3.setId("3");
        product3.setProductName("asus");
        product3.setPrice("300");
        System.out.println(product3.toString());

        Product product4 = new Product();
        product4.setId("4");
        product4.setProductName("lenovo");
        product4.setPrice("400");
        System.out.println(product4.toString());


        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        return products;
    }

    @PostMapping(path = "product/add")
    public String addProduct(@RequestBody Product request) {

        if (request.getProductName().equals("")) {
            return "Please input Project Name";
        }

        System.out.println(request.toString());
        System.out.println(request.getId());
        System.out.println(request.getProductName());
        System.out.println(request.getPrice());
        return "Save";
    }

    @PostMapping(path = "product/{id}/{name}")
    public Product getProductById(@PathVariable String id, @PathVariable String name) {
       products();

        return products.get(Integer.parseInt(id) - 1);
    }

}
