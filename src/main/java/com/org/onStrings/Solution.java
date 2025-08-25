package com.org.onStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    private String name;
    private Integer value;
    public Product() {}
    public Product(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

public class Solution {
    public static void main(String[] args) {
        List<Product> list1 = new ArrayList<>();
        list1.add(new Product("Apple", 10));
        list1.add(new Product("Dell", 8));
        List<Product> list2 = new ArrayList<>();
        list2.add(new Product("Apple", 5));
        list2.add(new Product("Dell", 2));
        list2.add(new Product("Acer", 5));
        List<Product> list3 = new ArrayList<>();
        list3.add(new Product("Hp", 2));
        list3.add(new Product("Acer", 5));
        List<List<Product>> listsOfProducts = new ArrayList<>();
        listsOfProducts.add(list1);
        listsOfProducts.add(list2);
        listsOfProducts.add(list3);
        printTotalProducts(listsOfProducts);
    }

    private static void printTotalProducts(List<List<Product>> listsOfProducts) {
        List<Product> list = listsOfProducts.stream().flatMap(listProduct -> listProduct.stream())
                .collect(Collectors.toList());
        Map<String, Integer> totalByName = listsOfProducts.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(
                        Product::getName,
                        Collectors.summingInt(Product::getValue)
                ));

        totalByName.forEach((name, total) -> System.out.println(name + " " + total));
    }

}
