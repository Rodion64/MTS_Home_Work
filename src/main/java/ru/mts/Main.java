package ru.mts;

import javax.swing.text.html.Option;

import static ru.mts.DiscountCalculator.calculateDiscount;

public class Main {
    public static void main(String[] args) {
        DiscountCalculator discountCalculator1 = new DiscountCalculator(1, 100.0, 0.75);
        calculateDiscount(discountCalculator1);

        DiscountCalculator discountCalculator2 = new DiscountCalculator(1, 1.0, 42.575);
        calculateDiscount(discountCalculator2);

        DiscountCalculator discountCalculator3 = new DiscountCalculator(1, 100.0, 59.1);
        calculateDiscount(discountCalculator3);
    }
}