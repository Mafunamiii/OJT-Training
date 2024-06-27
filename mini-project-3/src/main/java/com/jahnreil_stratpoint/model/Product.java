package com.jahnreil_stratpoint.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jahnreil_stratpoint.util.Measurement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The Product model contain attributes such as id, name, description, brand etc...
 * Product must be constructed with complete args
 */
@Getter
@Setter
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

    /**
     * Instantiates a new Product.
     *
     * @param id           the id
     * @param name         the name
     * @param description  the description
     * @param brand        the brand
     * @param manufacturer the manufacturer
     * @param price        the price
     * @param discount     the discount
     * @param quantity     the quantity
     * @param measurement  the measurement
     */
    @JsonCreator
    public Product(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("brand") String brand,
            @JsonProperty("manufacturer") String manufacturer,
            @JsonProperty("price") BigDecimal price,
            @JsonProperty("discount") BigDecimal discount,
            @JsonProperty("quantity") int quantity,
            @JsonProperty("measurement") Measurement measurement) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.measurement = measurement;
    }
}
