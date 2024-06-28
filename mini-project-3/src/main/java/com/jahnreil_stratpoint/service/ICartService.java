package com.jahnreil_stratpoint.service;

import com.jahnreil_stratpoint.model.Cart;
import com.jahnreil_stratpoint.model.CartItem;
import com.jahnreil_stratpoint.model.Product;

import java.util.Optional;

/**
 * Interface for managing the shopping cart operations.
 */
public interface ICartService {

    /**
     * Adds a product to the cart. If the product is already in the cart, increases its quantity.
     *
     * @param product the product to add
     * @param cart the cart to which the product is added
     * @return the updated cart
     */
    Cart addToCart(Product product, Cart cart);

    /**
     * Finds an item in the cart based on the product.
     *
     * @param cart the cart to search
     * @param product the product to find
     * @return an optional containing the found cart item, or empty if not found
     */
    Optional<CartItem> findItem(Cart cart, Product product);

    /**
     * Adds a cart item to the cart.
     *
     * @param cartItem the cart item to add
     * @param cart the cart to which the item is added
     * @return the updated cart
     */
    Cart addCartItemToCart(CartItem cartItem, Cart cart);

    /**
     * Removes a cart item from the cart.
     *
     * @param cartItem the cart item to remove
     * @param cart the cart from which the item is removed
     * @return the updated cart
     */
    Cart removeCartItemFromCart(CartItem cartItem, Cart cart);

    /**
     * Decreases the quantity of a product in the cart. If the quantity reaches 0, removes the item from the cart.
     *
     * @param cart the cart
     * @param product the product to decrease the quantity of
     * @return the updated cart
     */
    Cart decreaseCartItemFromItems(Cart cart, Product product);

    /**
     * Performs checkout for the cart.
     */
    void checkout();
}
