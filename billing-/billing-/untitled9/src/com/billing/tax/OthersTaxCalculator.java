package com.billing.tax;

import static com.billing.constants.Constants.OthersTaxRate;

public class OthersTaxCalculator implements TaxCalculator{
    @Override
    public double calculateTax(double amount) {
        return OthersTaxRate * amount;
    }
}
