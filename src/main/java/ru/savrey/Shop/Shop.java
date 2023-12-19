package ru.savrey.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        return products.stream().sorted(Comparator.comparingInt(Product::getCost)).toList();
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        return products.stream().reduce((a, b) -> a.getCost() > b.getCost() ? a : b).get();
    }

}
