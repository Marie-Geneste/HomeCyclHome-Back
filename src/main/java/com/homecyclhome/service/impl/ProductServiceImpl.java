package com.homecyclhome.service.impl;

import com.homecyclhome.model.Product;
import com.homecyclhome.repository.ProductRepository;
import com.homecyclhome.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Utilisation de la méthode findAll() du repository
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id); // Utilisation de la méthode findById() du repository
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product); // Utilisation de la méthode save() du repository
    }

    @Override
    public Product updateProduct(long id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found");
        }
        product.setId_product(id);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
