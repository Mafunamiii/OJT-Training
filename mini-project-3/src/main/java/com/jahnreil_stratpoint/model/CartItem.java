package com.jahnreil_stratpoint.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The CartItem takes product duplicates and return overall quantity and total price, must be constructed with complete args
 */
@Getter
@Setter
@AllArgsConstructor
public class CartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;
}
