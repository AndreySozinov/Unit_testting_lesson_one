package ru.savrey.Shop;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {
        /**
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
         (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice
         (проверьте правильность сортировки).
   */



        @Test
        public void testShopProductList() {
            Shop shop = new Shop();
            Product water = new Product(100, "Water");
            Product beer = new Product(300, "Beer");
            Product bread = new Product(50, "Bread");
            Product gloves = new Product(1000, "Gloves");
            Product boots = new Product(520, "Boots");
            List<Product> products = new ArrayList<>(Arrays.asList(
                   water, beer, bread, gloves, boots));
            shop.setProducts(products);

            assertThat(shop.getProducts())
                    .isNotEmpty()
                    .hasSize(5)
                    .doesNotHaveDuplicates()
                    .contains(water, beer, bread, gloves, boots);
        }

    @Test
    public void testShopMostExpensive() {
        Shop shop = new Shop();
        Product water = new Product(100, "Water");
        Product beer = new Product(300, "Beer");
        Product bread = new Product(50, "Bread");
        Product gloves = new Product(1000, "Gloves");
        Product boots = new Product(520, "Boots");
        List<Product> products = new ArrayList<>(Arrays.asList(
                water, beer, bread, gloves, boots));
        shop.setProducts(products);

        assertThat(shop.getMostExpensiveProduct().getCost() == 1000);
    }

    @Test
    public void testShopSorting() {
        Shop shop = new Shop();
        Product water = new Product(100, "Water");
        Product beer = new Product(300, "Beer");
        Product bread = new Product(50, "Bread");
        Product gloves = new Product(1000, "Gloves");
        Product boots = new Product(520, "Boots");
        List<Product> products = new ArrayList<>(Arrays.asList(
                water, beer, bread, gloves, boots));
        shop.setProducts(products);

        assertThat(shop.sortProductsByPrice())
                .isNotEmpty()
                .startsWith(bread)
                .endsWith(gloves);
    }
}
