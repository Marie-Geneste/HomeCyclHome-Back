package com.homecyclhome.controller;

import com.homecyclhome.model.Product;
import com.homecyclhome.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/product")

public class ProductController {
    @Autowired
    private ProductService productService;

    //GetAll Product
    @GetMapping
    public @ResponseBody List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

}
