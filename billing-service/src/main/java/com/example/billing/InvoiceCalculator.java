package com.example.billing;

/**
 * Deliberately tiny "business logic" class so the demo has something
 * real for Maven to compile and JUnit to test.
 */
public class InvoiceCalculator {

    public double calculateTotal(double subtotal, double taxRate) {
        return subtotal + (subtotal * taxRate);
    }
}
