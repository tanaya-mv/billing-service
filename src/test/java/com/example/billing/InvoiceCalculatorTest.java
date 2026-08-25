package com.example.billing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InvoiceCalculatorTest {

    @Test
    void calculatesTotalWithTax() {
        InvoiceCalculator calc = new InvoiceCalculator();
        // Demo note: change 110.0 to something wrong (e.g. 999.0)
        // to deliberately break this test for the "failing test" demo.
        assertEquals(110.0, calc.calculateTotal(99.0, 0.10), 0.0001);
    }
}
