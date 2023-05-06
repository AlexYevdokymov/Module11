package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static mainPackage.StreamZipper.zip;

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
        System.out.println();

        //Task 3
        String[] numbers = {"1, 2, 15, 0, 4, 7", "4, 5"};
        String nums = Arrays.stream(numbers)
                .map(n -> {
                    String[] nn = n.split(",");
                    return nn;
                })
                .flatMap(n -> Arrays.stream(n))
                .map(n -> Integer.parseInt(n.strip()))
                .sorted()
                .map(n -> n.toString())
                .collect(Collectors.joining(", "));
        System.out.println("Task 3:\n " + nums);
        System.out.println();

        //Task 4
        System.out.println("Task 4:");
        Randomizer rand = new Randomizer(25214903917L, 11L,(long) Math.pow(2,48));
        rand.createStream(2)
                .limit(7)
                .peek(System.out::println).collect(Collectors.toList());
        System.out.println();

        //Task 5
        Stream<String> firstStream = Stream.of("Q", "W", "E", "R", "T", "Y");
        Stream<String> secondStream = Stream.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> result = StreamZipper.zip(firstStream, secondStream)
                .collect(Collectors.toList());
        System.out.println("Task 5:\n" + result);
    }
}