package org.example;

import java.util.Arrays;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Charlie");

        names.parallelStream()
                .forEach(name -> System.out.print(name + "  "));
        System.out.println();
        names.parallelStream()
                .forEachOrdered(name -> System.out.print(name + "  "));
        System.out.println();
        names.parallelStream()
                .unordered()
                .forEach(name -> System.out.print(name + "  "));
    }
}
