package com.homecyclhome.repository;

import com.homecyclhome.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // méthodes personnalisées ici si nécessaire
}
