package com.java.news.predicate;

import com.java.news.model.Player;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayerPredicates {

    public static Predicate<Player> isOlympicAge() {
        return player -> player.getAge() <= 23;
    }

    public static Predicate<Player> isAgeMoreThan(final Integer age) {
        return player -> player.getAge() > age;
    }

    public static List<Player> filterPlayers(final List<Player> players, Predicate<Player> predicate) {
        return players.stream()
            .filter(predicate)
            .collect(Collectors.toList());
    }

}
