package com.java.news.consumer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsumerTest {

    private static final List<String> PLAYERS = Arrays.asList("Messi", "Cristiano", "Neymar", "Lewandowski");

    @Test
    void imprimirNome() {
        Consumer<String> printConsumer = System.out::println;

        printConsumer.accept("De Bruyne");
    }


    @Test
    void imprimirNomes() {
        Consumer<String> printConsumer = System.out::println;

        PLAYERS.forEach(printConsumer);
    }

    @Test
    void converterParaMaiusculaEImprimir() {
        Consumer<List<String>> upperCaseConsumer = list ->
            list.replaceAll(String::toUpperCase);

        Consumer<List<String>> printConsumer = list ->
            list.forEach(System.out::println);

        upperCaseConsumer.andThen(printConsumer).accept(PLAYERS);
    }

    @Test
    void concatenarNumero() {
        Consumer<List<String>> concatConsumer = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, i + 1 + " " + list.get(i));
            }
        };

        Consumer<List<String>> upperCaseConsumer = list ->
            list.replaceAll(String::toUpperCase);

        Consumer<List<String>> printConsumer = list ->
            list.forEach(System.out::println);

        concatConsumer.andThen(upperCaseConsumer).andThen(printConsumer).accept(PLAYERS);
    }

}
