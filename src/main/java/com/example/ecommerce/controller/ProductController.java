
package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    // Liste des produits en mémoire
    private List<Product> products = new ArrayList<>();

    // GET : Retourner tous les produits
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    // GET : Rechercher un produit par ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(
            @PathVariable String id) {

        for (Product product : products) {

            if (product.getId().equals(id)) {
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // POST : Ajouter un nouveau produit
    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestBody Product product) {

        products.add(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }
}
