package com.java.news.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class FunctionTest {

    private static final List<String> PLAYERS = Arrays.asList("Messi", "Cristiano", "Neymar", "Lewandowski", "Neilton", "Nahuel", "Nani", "Nah");

    @Test
    void retornarTamanhoLista() {
        Function<String, Integer> nameMappingFunction = String::length;

        List<Integer> namesLength = PLAYERS.stream()
            .map(nameMappingFunction)
            .toList();

        System.out.println(namesLength);
    }

    @Test
    void retornarPrimeirosCaracteres() {
        Function<String, String> nameMappingFunction = str -> str.substring(0, 3);

        List<String> initialChars = PLAYERS.stream()
            .map(nameMappingFunction)
            .toList();

        System.out.println(initialChars);
    }

    @Test
    void retornarTamanhoString() {
        Function<String, Integer> nameMappingFunction = String::length;

        System.out.println(nameMappingFunction.apply("Neymar"));
    }

}
