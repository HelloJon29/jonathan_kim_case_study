package com.jonathankim.monster_factory.monster_tests;

import com.jonathankim.monster_factory.location.Location;
import com.jonathankim.monster_factory.location.LocationRepository;
import com.jonathankim.monster_factory.monster.Monster;
import com.jonathankim.monster_factory.monster.MonsterRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonsterRepositoryTests {

    @Autowired
    private MonsterRepository monsterRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Before
    public void setup() {
        Location location = locationRepository.findByCountry("USA");
        Monster monster = new Monster("testMon",null,null,location);
        monsterRepository.save(monster);
        System.out.println("Setup Completed");
    }

    @After
    public void teardown() {
        monsterRepository.deleteAll();
        System.out.println("Teardown finished");
    }

    @Test
    public void findMonsterByNameReturnsMonsterGivenValidName() {
        Monster targetMonster = monsterRepository.findMonsterByName("testMon");

        assertThat(targetMonster.getName()).isEqualTo("testMon");
    }

    @Test
    public void findMonsterByIdReturnsMonsterGivenValidId() {
        Monster expectedMonster = monsterRepository.save(new Monster("testMon2"));
        Monster targetMonster = monsterRepository.findMonsterById(expectedMonster.getId());

        assertThat(targetMonster).isNotNull();
    }

    @Test
    public void findMonsterByIdReturnsNullGivenInvalidId() {
        Monster targetMonster = monsterRepository.findMonsterById(0);

        assertThat(targetMonster).isNull();
    }

    @Test
    public void findMonstersByLocationReturnsListOfMonstersGivenValidLocation() {

        List<Monster> monsterList = monsterRepository.findMonstersByLocation(locationRepository.getById(1l));

        System.out.println(monsterList);

        assertThat(monsterList).asList().hasSize(1);
    }
}
