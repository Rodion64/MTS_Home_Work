package ru.mts;

/**
 * Класс отвечает за расчет стоимости товара
 *
 * @version 1.0
 * @autor Сущев Родион
 */
public class DiscountCalculator {
    /**
     * целочисленная переменная для значений количества товара
     */
    private final int amountProduct;
    /**
     * вещественная переменная для стоимости единица товара товара
     */
    private final double priceProduct;
    /**
     * вещественная переменная для скидки
     */
    private final double discountOnProduct;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param amountProduct     количество единиц товара
     * @param priceProduct      цена на одну единицу товара
     * @param discountOnProduct скидка
     * @see DiscountCalculator#calculateDiscount(DiscountCalculator)
     */
    public DiscountCalculator(int amountProduct, double priceProduct, double discountOnProduct) {
        if (amountProduct <= 0 || priceProduct < 0 || (discountOnProduct < 0 || discountOnProduct > 100)) {
            throw new IllegalArgumentException(String.format("Incorrect arguments: [%s, %s, %s]", amountProduct, priceProduct, discountOnProduct));
        }
        this.amountProduct = amountProduct;
        this.priceProduct = priceProduct;
        this.discountOnProduct = discountOnProduct;
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
