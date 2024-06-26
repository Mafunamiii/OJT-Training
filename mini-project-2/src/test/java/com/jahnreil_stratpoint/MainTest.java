package com.jahnreil_stratpoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testMain() {
        // Simulate the main method and check for expected behavior
        Main.main(new String[]{});

        // Asserting the output (replace with your actual expected output)
        String expectedOutput = "Expected output"; // Update with your expected output
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @BeforeEach
    void tearDown() {
        // Reset stdout after each test
        System.setOut(originalOut);
    }
}
