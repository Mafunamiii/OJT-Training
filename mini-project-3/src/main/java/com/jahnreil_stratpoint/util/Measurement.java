package com.jahnreil_stratpoint.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Measurement.
 */
@Getter
@Setter
@NoArgsConstructor
public class Measurement {
    private double value;
    private Unit unit;

    /**
     * Instantiates a new Measurement.
     *
     * @param value the value
     * @param unit  the unit
     */
    public Measurement(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }
}
