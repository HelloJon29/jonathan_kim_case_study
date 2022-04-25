package com.jonathankim.monster_factory.monster;

import java.util.List;

public interface MonsterService {
    List<Monster> getAllMonsters();
    void saveMonster(Monster monster);
    Monster getMonsterById(long id);
    void deleteMonsterById(long id);

    // Custom Queries

}
