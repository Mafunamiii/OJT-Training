package com.jahnreil_stratpoint.controller;

import com.jahnreil_stratpoint.model.Cart;
import com.jahnreil_stratpoint.model.Product;
import com.jahnreil_stratpoint.util.LoadProductsData;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


/**
 * The ECommerceController class manages the overall e-commerce application, coordinating
 * between the main menu, product shelf, and shopping cart.
 */
@NoArgsConstructor
public class ECommerceController {
    private static final Logger logger = LoggerFactory.getLogger(MainMenuController.class);
    private ArrayList<Product> products = new ArrayList<>();
    private Cart cart = new Cart();
    private CartController cartController = new CartController(cart);
    private MainMenuController mainMenuController = new MainMenuController();
    private ProductShelfController productShelfController = new ProductShelfController(products, cartController);
    private LoadProductsData loadProductsData = new LoadProductsData();

    /**
     * Starts the e-commerce controller, initializing the product list and managing the main menu loop.
     */
    public void startECommerceController()  {
        // load static products into the application
        products = loadProductsData.loadProductsFromJSON();
        productShelfController.setProducts(products);

        while (true) {
            int mainMenuChoice = mainMenuController.menuChoice();

            switch (mainMenuChoice) {
                case 1:
                    logger.info("View Product Shelf, main menu choice: {}", mainMenuChoice);
                    productShelfController.showProducts(products);
                    break;
                case 2:
                    logger.info("View Cart, main menu choice: {}", mainMenuChoice);
                    cartController.viewCart(products);
                    break;
                case 3:
                    logger.info("Exiting program, main menu choice: {}", mainMenuChoice);
                    System.out.println("Exiting Program");
                    return;
            }
        }
    }
}
