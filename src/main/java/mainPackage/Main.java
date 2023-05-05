package mainPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alex");
        names.add("Donald");
        names.add("Garfield");
        names.add("Steve");
        names.add("Michael");
        names.add("Ronald");
        names.add("John");
        System.out.println("ArrayList for tests: \n" + names);
        System.out.println();

        //Task 1
        AtomicInteger counter = new AtomicInteger(1);
        List<String> namesTask1 = names.stream()
                .map(n -> {
                    String nn = counter.getAndIncrement() + ". " + n;
                    return nn;
                })
                .filter(n -> Integer.parseInt(n.split("\\.")[0]) % 2 != 0)
                .collect(Collectors.toList());
        System.out.println("Task 1: \n" + namesTask1);
        System.out.println();

        //Task 2
        List<String> namesTask2 = names.stream()
                .map(n -> n.toUpperCase())
                .sorted((a,b) -> b.compareTo(a))
                .collect(Collectors.toList());
        System.out.println("Task 2:\n Reverse-sorted and uppercased names:\n" + namesTask2);

        //Task 3

    }
}