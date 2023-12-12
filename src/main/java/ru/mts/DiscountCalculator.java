package ru.mts;

import java.util.Optional;

/**
 * Класс отвечает за расчет стоимости товара
 *
 * @version 1.0
 * @autor Сущев Родион
 */
public class DiscountCalculator {

    private final Integer amountProduct; //целочисленная переменная для значений количества товара

    private final Double priceProduct; //вещественная переменная для стоимости единица товара товара

    private final Double discountOnProduct;//вещественная переменная для скидки

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param amountProduct     количество единиц товара
     * @param priceProduct      цена на одну единицу товара
     * @param discountOnProduct скидка
     * @see DiscountCalculator#calculateDiscount(DiscountCalculator)
     */
    public DiscountCalculator(Integer amountProduct, Double priceProduct, Double discountOnProduct) {

        this.amountProduct = Optional.of(amountProduct)
                .filter(num -> num > 0)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Incorrect arguments: [%s, %s, %s]", amountProduct, priceProduct, discountOnProduct)));
        this.priceProduct = Optional.of(priceProduct)
                .filter(num -> num > 0)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Incorrect arguments: [%s, %s, %s]", amountProduct, priceProduct, discountOnProduct)));
        this.discountOnProduct = Optional.of(discountOnProduct)
                .filter(num -> num > 0 || num < 100)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Incorrect arguments: [%s, %s, %s]", amountProduct, priceProduct, discountOnProduct)));
    }

    /**
     * Метод для рассчета стоимости товара со скидкой и без скидки
     */
    public static void calculateDiscount(DiscountCalculator object) {
        double sum;
        double sumDiscount;
        sum = object.amountProduct * object.priceProduct;
        sumDiscount = sum * (1 - (object.discountOnProduct / 100));
        System.out.println("Общая сумма покупки без скидки: " + String.format("%.2f", sum));
        System.out.println("Общая сумма покупки со скидкой: " + String.format("%.2f", sumDiscount));
    }
}
