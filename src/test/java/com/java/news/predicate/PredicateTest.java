package com.java.news.predicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class PredicateTest {

    private static final List<String> PLAYERS = Arrays.asList("Messi", "Cristiano", "Neymar", "Lewandowski", "Neilton", "Nahuel", "Nani", "Nah");

    @Test
    void filtrarNomes() {
        Predicate<String> startPredicate = str -> str.startsWith("N");

        PLAYERS.stream()
            .filter(startPredicate)
            .forEach(System.out::println);
    }

    @Test
    void filtrarNomesETamanhos() {
        Predicate<String> startPredicate = str -> str.startsWith("N");
        Predicate<String> lengthPredicate = str -> str.length() <= 4;

        PLAYERS.stream()
            .filter(startPredicate.and(lengthPredicate))
            .forEach(System.out::println);
    }

}
