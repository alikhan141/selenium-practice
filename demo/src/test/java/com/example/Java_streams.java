package com.example;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Java_streams {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Don");
        names.add("Arsalan");
        names.add("Adam");
        names.add("Saif");
        // int count = 0;
        // for (int i = 0; i < names.size(); i++) {
        // String actual = names.get(i);
        // if (actual.startsWith("A")) {
        // count++;
        // }
        // }
        // System.out.println(count);
        int final_name = (int) names.stream().filter(s -> s.startsWith("A")).count();
        Stream.of("apple", "banana", "orange");

    }
}