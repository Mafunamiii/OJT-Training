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
 * The Cart takes different cartItems and assigns these cartItems containing products into an arrayList named cartItems
 * The Cart can be constructed with all args or no args
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
}
