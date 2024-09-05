package com.example.ecommerce.product_service.controller;

import com.example.ecommerce.product_service.entity.Product;
import com.example.ecommerce.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

        @Autowired
        private final ProductService productService;

        @Autowired
        public ProductController(ProductService productService) {
            this.productService = productService;
        }

        @GetMapping
        public List<Product> getAllProduct()
        {
            return productService.getAllProducts();f
        }

        @GetMapping("/{id}")
        public Product getProductById(@PathVariable("id") Long id)
        {
            return productService.getProductById(id);
        }

        @PostMapping
        public Product addProduct(@RequestBody Product product)
        {
            return productService.saveProduct(product);
        }

        @PutMapping("/{id}")
        public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product)
        {
            Product existProduct= productService.getProductById(id);
            existProduct.setName(product.getName());
            existProduct.setDescription(product.getDescription());
            existProduct.setPrice(product.getPrice());
            return productService.saveProduct(existProduct);

        }

        @DeleteMapping("/{id}")
        public void deleteProduct(@PathVariable("id") Long id)
        {
            productService.deleteProduct(id);
        }



}
