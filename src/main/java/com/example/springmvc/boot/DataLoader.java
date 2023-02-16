package com.example.springmvc.boot;

import com.example.springmvc.model.Product;
import com.example.springmvc.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private ProductRepo productRepo;

    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Product product1 = new Product();
        product1.setName("Test Product");
        product1.setDescription("Description");
        product1.setType("Type");
        product1.setCategory("Cat");
        product1.setPrice(0.0);

        productRepo.save(product1);

        Product product2 = new Product();
        product2.setName("Test Product2");
        product2.setDescription("Descriptionn");
        product2.setType("Typee");
        product2.setCategory("Catt");
        product2.setPrice(0.0);

        productRepo.save(product2);

    }
}
