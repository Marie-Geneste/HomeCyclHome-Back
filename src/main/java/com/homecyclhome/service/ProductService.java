package com.homecyclhome.service;

import com.homecyclhome.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts(); // Pour récupérer tous les produits
    Optional<Product> getProductById(long id); // Pour récupérer un produit par son ID
    Product saveProduct(Product product); // Pour enregistrer un produit
    Product updateProduct(long id, Product product); // Pour mettre à jour un produit
    void deleteProduct(long id); // Pour supprimer un produit
}
