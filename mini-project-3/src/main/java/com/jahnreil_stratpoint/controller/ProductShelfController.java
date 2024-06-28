package com.jahnreil_stratpoint.controller;

import com.jahnreil_stratpoint.model.Cart;
import com.jahnreil_stratpoint.model.Product;
import com.jahnreil_stratpoint.util.InputCheck;
import com.jahnreil_stratpoint.util.InputType;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * The type Product shelf controller.
 * This class is responsible for managing the product shelf and handling user interactions
 * related to viewing and adding products to the cart.
 */
@Getter
@Setter
public class ProductShelfController {
    public ArrayList<Product> products = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(ProductShelfController.class);
    private Cart cart = new Cart();
    private CartController cartController;

    /**
     * Instantiates a new Product shelf controller with the given list of products and cart controller.
     *
     * @param products       the list of products to be displayed on the shelf
     * @param cartController the cart controller to manage cart operations
     */
    public ProductShelfController(ArrayList<Product> products, CartController cartController) {
        this.products = products;
        this.cartController = cartController;
        logger.info("ProductShelfController instantiated with products: {}", products);
    }

    /**
     * Displays the list of products in a paginated format and handles user interactions
     * for adding products to the cart and navigating between pages.
     *
     * @param products the list of products to be displayed
     */
    public void showProducts(ArrayList<Product> products) {
        logger.info("showProducts called with products: {}", products);
        int pageSize = 10;
        int currentPage = 1;
        int productsPage = 0;
        int targetPage = pageSize - 1;

        try {
            while (true) {
                logger.info("Displaying products on page {}", currentPage);
                System.out.println(
                        """
                         +----+----------------------------------------------+-------------------+------------+---------------------------+-----------------------------------------------------+
                         | ID | Product Name                                 | Brand             | Price      | Category                  | Description                                         |
                         +----+----------------------------------------------+-------------------+------------+---------------------------+-----------------------------------------------------+
                        """
                );
                if (targetPage >= products.size()) {
                    targetPage = products.size() - 1;
                }
                for (int i = productsPage; i <= targetPage; i++) {
                    Product product = products.get(i);
                    System.out.println(String.format(
                            "| %3d | %-44s | %-20s | $%-10.2f | %-20s | %-40s |",
                            product.getId(),
                            product.getName(),
                            product.getBrand(),
                            product.getPrice(),
                            product.getCategory(),
                            product.getDescription()
                    ));
                }
                System.out.println("+----+----------------------+-------------------+------------+---------------------------+---------------------------+");
                System.out.println("============================================= Page " + currentPage + " ==============================================\n" +
                        "[1] Add to cart\n" +
                        "[2] View next page\n" +
                        "[3] View previous page\n" +
                        "[4] Back to Main Menu\n");

                String inputStr = MainMenuController.inputscan.nextLine();
                logger.info("User input: {}", inputStr);
                InputCheck inputCheck = InputCheck.inputCheckValues(inputStr, 4, InputType.INT_WITH_MAX_CHOICE);

                if (inputCheck.isValid()) {
                    switch ((Integer) inputCheck.getValue()) {
                        case 1:
                            logger.info("User selected add to cart");
                            cartController.setCart(cartController.addToCart(cartController.getCart(), products));
                            cartController.viewCart(products);
                            break;
                        case 2:
                            logger.info("User selected next page");
                            if (targetPage < products.size() - 1) {
                                productsPage += pageSize;
                                targetPage += pageSize;
                                currentPage++;
                            } else {
                                System.out.println("\n\n===== No more pages to view. =====");
                            }
                            break;
                        case 3:
                            logger.info("User selected previous page");
                            if (productsPage > 0) {
                                productsPage -= pageSize;
                                targetPage = productsPage + pageSize - 1;
                                currentPage--;
                            } else {
                                System.out.println("\n\n===== Already on the first page. =====");
                            }
                            break;
                        case 4:
                            logger.info("User selected back to main menu");
                            return;
                        default:
                            logger.warn("Invalid input: {}", inputStr);
                            System.out.println("Invalid input, select from the choices");
                            break;
                    }
                }
            }

        } catch (Exception e) {
            logger.error("Error displaying products: {}", e.getMessage());
            e.printStackTrace();
        }
        logger.info("showProducts ended");
    }
}
