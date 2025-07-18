package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Java_streams {
    public static void main(String[] args) {
        Java_streams object = new Java_streams();
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
        System.out.println(final_name);
        long count = Stream.of("Ali", "Arsalan", "Muneeb", "Ahmed", "Ismail").filter(s -> s.startsWith("A")).count();
        System.out.println(count);
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
        // names.stream().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        List<String> words = Arrays.asList("apple", "banana", "cat");
        words.stream().map(String::toUpperCase).forEach(System.out::println); // giving length of each word

        // object.streamMap();
        // object.even_numbers();
        object.sorted();
        object.concat();
        object.streamcollect();

    }

    public void streamMap() {
        // print name which has length > 4 also in uppercase
        Stream.of("Alina", "Arsalan", "Muneeba", "Ahmed", "Ismail").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));

    }

    public void even_numbers() {

        Stream.of("1,2,3,4,5,6").map(s -> Integer.parseInt(s)).filter(s -> s % 2 == 0)
                .forEach(s -> System.out.println(s));
    }

    public void sorted() {
        Stream.of("Ali, Arsalan, Ash, ").filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));
    }

    public void concat() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Ali");
        names.add("Don");
        names.add("Arsalan");
        names.add("Adam");
        names.add("Saif");

        ArrayList<String> names1 = new ArrayList<>();
        names1.add("Muneeb");
        names1.add("Ahmed");
        names1.add("Ismail");
        names1.add("Arsalan");

        Stream<String> stream1 = Stream.concat(names.stream(), names1.stream());
        boolean flag = stream1.anyMatch(s -> s.equals("Arsalan"));
        System.out.println(flag);
        Assert.assertTrue(flag, "Arsalan is present in the list");
    }

    public void streamcollect() {

        List<String> ls = Stream.of("Alina", "Arsalan", "Muneeb", "Ahmed", "Ismaila").filter(s -> s.endsWith("a"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        // distinct values
        List<String> values = Arrays.asList("1", "2", "3", "4", "5", "1", "2", "3", "4", "5");
        values.stream().distinct().forEach((s -> System.out.println(s)));

    }

}