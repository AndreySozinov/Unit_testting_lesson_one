package ru.savrey;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Main {
    public static void main(String[] args) {
        assertConditionA();
        assertConditionB();
        //Integer.MAX_VALUE, Integer.MAX_VALUE);
        //happyNY();
        //checkingShoppingCart();
        expectedValue();

        String[] colors = {"aqua", "yellow", "blue", "orange", "green", "violet", "gold"};
        testingJavaCollectionsAssertJ(colors);

        checkingHero();
    }

    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дня выходных.");
    }

    public static void assertConditionB() {
        int x = -1;
        assert x <= 0;
    }

    public static int sum(int a, int b) {
        assert a + b > Integer.MAX_VALUE : "Переполнение";
        return a+b;
    }

    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(calendar.getTime());

        assert currentDateTime.compareTo("01/01/2024 00:00:00") < 0 : "Еще 2023 год :(";
        System.out.println("С новым годом!");
    }

    public static void checkingShoppingCart() {
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
        products.add("water");
        for (String product : products) {
            switch (product) {
                case "apple":
                    System.out.println("category: " + productCategories.get(0));
                    break;
                case "tomato":
                    System.out.println("category: " + productCategories.get(1));
                    break;
                case "bread":
                    System.out.println("category: " + productCategories.get(2));
                    break;
                default:
                    assert false : "Unknown category for the product " + product;
                    break;
            }
        }
    }

    public static void expectedValue() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }


    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()
                .hasSize(7)
                .doesNotHaveDuplicates()
                .contains("orange", "green", "violet")
                .endsWith("gold")
                .startsWith("aqua")
                .containsSequence("yellow", "blue")
                .doesNotContain("red", "black");
    }

    public static void checkingHero() {
        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmet = new Hero("Emmett", 50, "sword", heroBag, true);
        assertThat(emmet.name).isEqualTo("Emmett");
        assertThat(emmet.armour).isEqualTo(50);
        assertThat(emmet.weapon).isEqualTo("sword");
        assertThat(emmet.heroBag)
                .hasSize(3)
                .contains("Bow", "Axe", "Gold");
        assertThat(emmet.isHuman).isTrue();
    }
}

class Hero{
    public String name;
    public int armour;
    public String weapon;
    public List<String> heroBag;
    public boolean isHuman;

    public Hero(String name, int armour, String weapon, List<String> heroBag, boolean isHuman) {
        this.name = name;
        this.armour = armour;
        this.weapon = weapon;
        this.heroBag = heroBag;
        this.isHuman = isHuman;
    }
}