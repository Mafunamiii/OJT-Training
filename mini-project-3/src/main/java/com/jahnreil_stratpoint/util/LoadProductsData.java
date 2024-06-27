package com.jahnreil_stratpoint.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jahnreil_stratpoint.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class LoadProductsData {
    private static final Logger logger = LoggerFactory.getLogger(LoadProductsData.class);
    private static final String PRODUCT_JSON_FILE = "src/main/java/com/jahnreil_stratpoint/productData/products.JSON";

    public ArrayList<Product> loadProductsFromJSON () {
        ArrayList<Product> products = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            products = mapper.readValue(Paths.get(PRODUCT_JSON_FILE).toFile(), new TypeReference<ArrayList<Product>>() {});
            logger.info("Loaded {} products from JSON file", products.size());
        } catch (IOException e) {
            logger.error("Error loading products from JSON file: {}", e.getMessage(), e);
        }

        return products;
    }
}
