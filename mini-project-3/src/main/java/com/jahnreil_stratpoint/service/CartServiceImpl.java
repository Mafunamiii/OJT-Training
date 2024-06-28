package com.jahnreil_stratpoint.service;

import com.jahnreil_stratpoint.model.Cart;
import com.jahnreil_stratpoint.model.CartItem;
import com.jahnreil_stratpoint.model.Product;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

/**
 * Implementation of the ICartService interface, providing services for managing the shopping cart.
 */
@Getter
@Setter
public class CartServiceImpl implements ICartService {
    private static final Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);
    private static ArrayList<CartItem> cartItems = new ArrayList<>();
    private static Cart cart = new Cart();

    /**
     * Adds a product to the cart. If the product is already in the cart, increases its quantity.
     *
     * @param product the product to add
     * @param cart the cart to which the product is added
     * @return the updated cart
     */
    public Cart addToCart(Product product, Cart cart) {
        cartItems = cart.getCartItems();
        Optional<CartItem> cartFind = findItem(cart, product);

        if (cartFind.isPresent()) {
            cartFind.get().setQuantity(cartFind.get().getQuantity() + 1);
        } else {
            cart = addCartItemToCart(new CartItem(product, 1, product.getPrice()), cart);
        }

        return cart;
    }

    /**
     * Finds an item in the cart based on the product.
     *
     * @param cart the cart to search
     * @param product the product to find
     * @return an optional containing the found cart item, or empty if not found
     */
    public Optional<CartItem> findItem(Cart cart, Product product) {
        Optional<CartItem> existingItem = cart.getCartItems().stream()
                .filter(item -> item.getProduct().getId() == product.getId())
                .findFirst();
        return existingItem;
    }

    /**
     * Finds a cart item by its product ID.
     *
     * @param id the product ID
     * @return the found cart item, or null if not found
     */
    public static CartItem findCartItemById(int id) {
        Optional<CartItem> foundItem = cartItems.stream()
                .filter(item -> item.getProduct().getId() == id)
                .findFirst();
        logger.info("Found cart item: {}", foundItem.orElse(null));
        return foundItem.orElse(null);
    }

    /**
     * Adds a cart item to the cart.
     *
     * @param cartItem the cart item to add
     * @param cart the cart to which the item is added
     * @return the updated cart
     */
    public Cart addCartItemToCart(CartItem cartItem, Cart cart) {
        cart.addCarItem(cartItem, cart);
        return cart;
    }

    /**
     * Removes a cart item from the cart.
     *
     * @param cartItem the cart item to remove
     * @param cart the cart from which the item is removed
     * @return the updated cart
     */
    public Cart removeCartItemFromCart(CartItem cartItem, Cart cart) {
        cart.removeCartItem(cartItem, cart);
        return cart;
    }

    /**
     * Decreases the quantity of a product in the cart. If the quantity reaches 0, removes the item from the cart.
     *
     * @param cart the cart
     * @param product the product to decrease the quantity of
     * @return the updated cart
     */
    public Cart decreaseCartItemFromItems(Cart cart, Product product) {
        Optional<CartItem> cartFind = findItem(cart, product);

        if (cartFind.isPresent()) {
            cartFind.get().setQuantity(cartFind.get().getQuantity() - 1);
        } else if (cartFind.isPresent() && cartFind.get().getQuantity() == 1) {
            cart = removeCartItemFromCart(cartFind.get(), cart);
        }
        return cart;
    }

    /**
     * Gets the total price of a cart item.
     *
     * @param cartItem the cart item
     * @return the total price of the cart item
     */
    public static BigDecimal getaCartItemTotal(CartItem cartItem) {
        cartItem.calculateTotal();
        return cartItem.getTotalPrice();
    }

    /**
     * Updates the total price of all cart items.
     *
     * @param cartItems the cart items
     * @return the updated total price
     */
    public static BigDecimal updateCartItemTotal(ArrayList<CartItem> cartItems) {
        BigDecimal total = cartItems.stream()
                .map(CartServiceImpl::getaCartItemTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    /**
     * Gets the total price of all items in the cart.
     *
     * @return the total price of all items in the cart
     */
    public static BigDecimal getCartItemsTotal() {
        BigDecimal total = cartItems.stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    /**
     * Checks out the cart.
     */
    public void checkout() {
        // Checkout logic to be implemented
    }
}
