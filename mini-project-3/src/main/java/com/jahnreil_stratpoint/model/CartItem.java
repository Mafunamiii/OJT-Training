package com.jahnreil_stratpoint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The CartItem class represents an item in the shopping cart.
 * It holds a reference to a Product, the quantity of the product, and the total price.
 * The CartItem must be constructed with all arguments.
 */
@Getter
@Setter
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    /**
     * Calculates the total price for the CartItem based on the product price and quantity.
     * The totalPrice is reset to 0 before recalculating.
     *
     * @return the total price of the CartItem
     */
    public BigDecimal calculateTotal() {
        totalPrice = BigDecimal.valueOf(0); // reset the totalPrice to 0 first
        totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
        return totalPrice;
    }
}
