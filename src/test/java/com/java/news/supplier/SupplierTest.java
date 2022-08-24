package com.java.news.supplier;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Supplier;

class SupplierTest {

    @Test
    void retornaValor() {
        Supplier<Double> doubleSupplier = Math::random;

        System.out.println(doubleSupplier.get());
    }

    @Test
    void comOptional() {
        Supplier<Double> doubleSupplier = Math::random;
        Optional<Double> doubleOptional = Optional.empty();

        System.out.println(doubleOptional.orElseGet(doubleSupplier));
    }

}
