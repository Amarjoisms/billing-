package com.billing.tax;

import static com.billing.constants.Constants.MedicineTaxRate;

public class MedicineTaxCalculator implements TaxCalculator{
    @Override
    public double calculateTax(double amount) {
        return MedicineTaxRate * amount;
    }
}
