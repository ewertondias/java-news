package com.java.news.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Builder
@ToString
public class Player {

    private final UUID id;
    private final String name;
    private final String team;
    private final Integer age;

}
