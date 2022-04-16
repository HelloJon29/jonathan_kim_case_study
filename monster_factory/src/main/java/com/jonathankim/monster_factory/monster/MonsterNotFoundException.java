package com.jonathankim.monster_factory.monster;

public class MonsterNotFoundException extends RuntimeException {
    public MonsterNotFoundException(long id) {
        super("Could not find Monster ID: " + id);
    }
}
