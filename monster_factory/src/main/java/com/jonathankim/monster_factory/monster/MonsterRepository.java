package com.jonathankim.monster_factory.monster;

import com.jonathankim.monster_factory.color.Color;
import com.jonathankim.monster_factory.location.Location;
import com.jonathankim.monster_factory.monster.Monster;
import com.jonathankim.monster_factory.size.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {
    Monster findMonsterById(long id);
    Monster findMonsterByName(String name);

    List<Monster> findMonstersByLocation(Location location);
}
