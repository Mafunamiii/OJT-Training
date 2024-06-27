package com.jahnreil_stratpoint.service;

import com.jahnreil_stratpoint.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

/**
 * The interface Product service.
 */
public interface IProductService {
    /**
     * Calculates the total price for the given product.
     *
     * @param product The product for which to calculate the total price.
     * @return The total price of the product as a BigDecimal.
     */
    BigDecimal calculateTotalPrice(Product product);
    /**
     * Creates a new product.
     *
     * @param product The product object containing details of the new product to create.
     * @return The created product object.
     */
    Product createProduct(Product product);
    /**
     * Retrieves a list of products.
     *
     * @param products The list of products to retrieve.
     */
    void retrieveProducts(ArrayList<Product> products);
    /**
     * Updates an existing product.
     *
     * @param product The product object containing updated details.
     * @return The updated product object.
     */
    Product updateProduct(Product product);
    /**
     * Deletes a product by its ID.
     *
     * @param productId The ID of the product to delete.
     */
    void deleteProduct(int productId);
    /**
     * Finds a product by its ID in the given list of products.
     *
     * @param products The list of products to search in.
     * @param id       The ID of the product to find.
     * @return An Optional containing the product if found, otherwise an empty Optional.
     */
    Optional<Product> findProduct(ArrayList<Product> products, int id);
    /**
     * Searches for products based on certain criteria.
     *
     * @param products The list of products to search within.
     */
    void searchProduct(ArrayList<Product> products);
    /**
     * Views details of products.
     *
     * @param products The list of products to view details of.
     */
    void viewProduct(ArrayList<Product> products);
}
