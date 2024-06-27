package com.jahnreil_stratpoint.controller;

import lombok.NoArgsConstructor;

/**
 * The type Main menu controller.
 */
@NoArgsConstructor
public class MainMenuController {
    /**
     * Menu choice int.
     *
     * @return the int
     */
    public int menuChoice() {
        int menuChoiceResult = 0;

        while (true) {
            System.out.println(
                    """
                    ==========================================
                    
                                    JG Market
                              [1] Browse Products
                              [2] View Cart
                              [3] Exit Program
                              
                    ==========================================
                    ►""");

            break;
        }

        return menuChoiceResult;
    }
}
