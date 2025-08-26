package com.billing.tax;

import static com.billing.constants.Constants.FoodTaxRate;

public class FoodTaxCalculator implements TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return FoodTaxRate * amount;
    }
}
