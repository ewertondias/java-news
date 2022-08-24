package com.java.news.predicate;

import com.java.news.model.Player;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

class PlayerPredicateTest {

    private static final String PSG = "PSG";
    private static final String REAL = "Real";
    private static final String BARCA = "Raphinha";
    private static final String SPFC = "São Paulo";
    private static final String VASCO = "Vasco";

    private final Player MESSI = Player.builder().id(UUID.randomUUID()).name("Messi").team(PSG).age(35).build();
    private final Player NEYMAR = Player.builder().id(UUID.randomUUID()).name("Neymar").team(PSG).age(30).build();
    private final Player VINI = Player.builder().id(UUID.randomUUID()).name("Vini Junior").team(REAL).age(22).build();
    private final Player RAPHINHA = Player.builder().id(UUID.randomUUID()).name("Raphinha").team(BARCA).age(25).build();
    private final Player RODRYGO = Player.builder().id(UUID.randomUUID()).name("Rodrygo").team(BARCA).age(21).build();
    private final Player IGOR_GOMES = Player.builder().id(UUID.randomUUID()).name("Igor Gomes").team(SPFC).age(23).build();
    private final Player NENE = Player.builder().id(UUID.randomUUID()).name("Nenê").team(VASCO).age(41).build();

    private final List<Player> PLAYERS = List.of(MESSI, NEYMAR, VINI, RAPHINHA, RODRYGO, IGOR_GOMES, NENE);

    @Test
    void jogadoresComIdadeOlimpica() {
        var olympicPlayers = PlayerPredicates.filterPlayers(PLAYERS, PlayerPredicates.isOlympicAge());

        olympicPlayers.forEach(player -> System.out.println(player.getName()));
    }

    @Test
    void jogadoresSemIdadeOlimpica() {
        var notOlympicPlayers = PlayerPredicates.filterPlayers(PLAYERS, PlayerPredicates.isOlympicAge().negate());

        notOlympicPlayers.forEach(player -> System.out.println(player.getName()));
    }

    @Test
    void jogadoresMaioresDe40Anos() {
        PLAYERS.stream()
            .filter(PlayerPredicates.isAgeMoreThan(40))
            .forEach(System.out::println);
    }

}
