package com.jahnreil_stratpoint.controller;

import com.jahnreil_stratpoint.model.Cart;
import com.jahnreil_stratpoint.model.CartItem;
import com.jahnreil_stratpoint.model.Product;
import com.jahnreil_stratpoint.service.CartServiceImpl;
import com.jahnreil_stratpoint.util.InputCheck;
import com.jahnreil_stratpoint.util.InputType;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Controller class for managing operations related to the shopping cart.
 */
@Getter
@Setter
public class CartController {
    private static final Logger logger = LoggerFactory.getLogger(CartController.class);
    private Cart cart = new Cart();
    private CartServiceImpl cartService;

    /**
     * Constructor to initialize the CartController with a cart instance.
     *
     * @param cart The cart instance to be managed by this controller.
     */
    public CartController(Cart cart) {
        this.cart = cart;
        this.cartService = new CartServiceImpl();
        logger.info("CartController instantiated");
    }

    /**
     * Adds a selected product to the shopping cart.
     *
     * @param cart     The current cart instance.
     * @param products List of available products to choose from.
     * @return Updated cart instance after adding the product.
     */
    public Cart addToCart(Cart cart, ArrayList<Product> products) {
        logger.info("User selected add to cart");
        System.out.println("\n\n===== Add to cart =====");
        System.out.print("Enter id to add to cart: ");

        String inputStr = MainMenuController.inputscan.nextLine();
        logger.info("User input: {}", inputStr);
        InputCheck inputCheck = InputCheck.inputCheckValues(inputStr, products.size(), InputType.INT_WITH_MAX_CHOICE);

        if (inputCheck.isValid()) {
            int id = (int) inputCheck.getValue();
            cart = cartService.addToCart(products.get(id - 1), cart);
            System.out.println("===== Added to cart =====");
            logger.info("Added product to cart: {}", products.get(id - 1));
        }
        return cart;
    }

    /**
     * Displays the contents of the shopping cart and handles user interactions.
     *
     * @param products List of available products for displaying cart items.
     */
    public void viewCart(ArrayList<Product> products) {
        while (true) {
            System.out.println("Cart Items: ");
            if (cart.getCartItems().isEmpty()) {
                System.out.println("No items in the cart.");
            } else {
                System.out.print("""
                ID   | Product                                            | Price      | Quantity | Total Price
                +----+----------------------------------------------------+------------+----------+-------------+
                """);
                for (CartItem cartItem : cart.getCartItems()) {
                    System.out.println(String.format(
                            " %-3d | %-50s | $%-10.2f | %-8d | $%-10.2f",
                            cartItem.getProduct().getId(),
                            cartItem.getProduct().getName(),
                            cartItem.getProduct().getPrice(),
                            cartItem.getQuantity(),
                            CartServiceImpl.getaCartItemTotal(cartItem)
                    ));
                }
            }

            System.out.println("Cart Total: $" + CartServiceImpl.updateCartItemTotal(cart.getCartItems()));
            System.out.println(
                    """
                    ===================================
                    [1] Add more items
                    [2] Decrease item
                    [3] Checkout
                    [4] Exit
                    ===================================
                    ►""");
            String input = MainMenuController.inputscan.nextLine();
            InputCheck inputCheck = InputCheck.inputCheckValues(input, 4, InputType.INT_WITH_MAX_CHOICE);

            if (inputCheck.isValid()) {
                switch ((Integer) inputCheck.getValue()) {
                    case 1:
                        logger.info("User selected add to cart, cart has: ", cart.getCartItems().size());
                        this.cart = this.addToCart(this.cart, products);
                        break;
                    case 2:
                        logger.info("User selected decrease item, cart has: ", cart.getCartItems().size());
                        this.cart = this.decreaseCartItem(this.getCart());
                        break;
                    case 3:
                        logger.info("User selected checkout, cart has: ", cart.getCartItems().size());
                        System.out.println("To be implemented soon");
                        break;
                    case 4:
                        logger.info("User selected exit, cart has: ", cart.getCartItems().size());
                        return;
                    default:
                        logger.info("Invalid input");
                        break;
                }
            }
        }
    }

    /**
     * Handles the decrease quantity functionality for an item in the shopping cart.
     */
    private Cart decreaseCartItem(Cart cart) {
        System.out.println("\n\n===== Decrease Item =====");
        System.out.print("Enter ID to decrease quantity: ");
        String inputStr = MainMenuController.inputscan.nextLine();
        logger.info("User input: {}", inputStr);

        // Validate input against current cart items IDs
        InputCheck inputCheck = InputCheck.inputCheckValues(inputStr, 0, InputType.INT_ONLY);

        logger.info("Input check result: {}",(Integer) inputCheck.getValue());
        logger.info("Input check validity result: {}", inputCheck.isValid());
        if (inputCheck.isValid()) {

            int id = (int) inputCheck.getValue();
            CartItem cartItem = cartService.findCartItemById(id);
            if (cartItem != null) {
                if (cartItem.getQuantity() > 1) {
                    cartItem.setQuantity(cartItem.getQuantity() - 1);
                    logger.info("Quantity decreased for cart item: {}", cartItem);
                } else {
                    this.cart = cartService.removeCartItemFromCart(cartItem, this.cart);
                    logger.info("Removed cart item from cart: {}", cartItem);
                }
                System.out.println("Quantity decreased for: " + cartItem.getProduct().getName());
            } else {
                System.out.println("Invalid ID. No item found in the cart with ID " + id);
            }
        } else {
            System.out.println("Invalid Input");
        }
        return cart;
    }
}
