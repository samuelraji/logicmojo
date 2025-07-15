package org.example;

import java.util.stream.Stream;

public class StreamIterateExample {

    public static void main(String[] args) {
        // Generate an infinite stream of numbers starting from 1
        Stream<Integer> numbers = Stream.iterate(1, n -> n + 1);

        // Limit the stream to the first 10 numbers and print them
        numbers.limit(10).forEach(System.out::println);
    }

}
