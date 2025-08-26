package com.billing.tax;

import com.billing.model.ItemType;

public class TaxCalculatorFactory {
    public TaxCalculator taxCalculator(ItemType type) {
        switch (type) {
            case Medicine: return new MedicineTaxCalculator();
            case Food: return new FoodTaxCalculator();
            case Others:
            default: return new OthersTaxCalculator();
        }
    }
}
