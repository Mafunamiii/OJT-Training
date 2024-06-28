package com.jahnreil_stratpoint.model;

import com.jahnreil_stratpoint.util.PaymentOptions;
import com.jahnreil_stratpoint.util.ShippingOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * The Cart class represents a shopping cart that holds multiple CartItems.
 * It provides methods to add and remove items from the cart.
 * The Cart can be constructed with all arguments or with no arguments.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private ArrayList<CartItem> cartItems = new ArrayList<>();
    private BigDecimal total;
    private PaymentOptions paymentOption;
    private ShippingOptions shippingOption;

    /**
     * Adds a CartItem to the cart.
     *
     * @param cartItem the cart item to be added
     * @param cart the cart to which the item is added
     * @return the updated cart with the new item added
     */
    public Cart addCarItem(CartItem cartItem, Cart cart) {
        cart.getCartItems().add(cartItem);
        return cart;
    }

    /**
     * Removes a CartItem from the cart.
     *
     * @param cartItem the cart item to be removed
     * @param cart the cart from which the item is removed
     * @return the updated cart with the item removed
     */
    public Cart removeCartItem(CartItem cartItem, Cart cart) {
        cart.getCartItems().remove(cartItem);
        return cart;
    }
}
