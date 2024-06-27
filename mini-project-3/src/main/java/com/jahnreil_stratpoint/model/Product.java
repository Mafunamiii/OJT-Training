package com.jahnreil_stratpoint.model;

import com.jahnreil_stratpoint.util.Measurement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The Product model contain attributes such as id, name, description, brand etc...
 * Product must be constructed with complete args
 */
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private String description;
    private String brand;
    private String manufacturer;
    private BigDecimal price;
    private BigDecimal discount;
    private int quantity;
    private Measurement measurement;
}
