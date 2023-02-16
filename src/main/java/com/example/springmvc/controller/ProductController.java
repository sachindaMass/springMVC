package com.example.springmvc.controller;

import com.example.springmvc.model.Product;
import com.example.springmvc.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private ProductRepo productRepo;

    @Autowired
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/products/add",method = RequestMethod.GET)
    public String createProduct(Model model){
        model.addAttribute("products",new Product());
        return "edit";
    }

    @RequestMapping(path="products",method=RequestMethod.POST)
    public String saveProduct(Product product){
        productRepo.save(product);
        return "redirect:/";
    }

    @RequestMapping(path="/products",method=RequestMethod.GET)
    public String getAllProducts(Model model){
        model.addAttribute("product",productRepo.findAll());
        return "products";
    }

    @RequestMapping(path = "/products/edit/{id}",method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id")String id){
        model.addAttribute("products", productRepo.findById(id));
        return "edit";
    }

    @RequestMapping(path="/products/delete/{id}",method = RequestMethod.GET)
        public String deleteProduct(@PathVariable(name="id")String id){
          productRepo.deleteById(id);
          return "redirect/:products";
        }

}
