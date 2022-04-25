package com.jonathankim.monster_factory.monster_tests;

import com.jonathankim.monster_factory.color.Color;
import com.jonathankim.monster_factory.location.Location;
import com.jonathankim.monster_factory.location.LocationRepository;
import com.jonathankim.monster_factory.monster.Monster;
import com.jonathankim.monster_factory.monster.MonsterNotFoundException;
import com.jonathankim.monster_factory.monster.MonsterRepository;
import com.jonathankim.monster_factory.monster.MonsterServiceImpl;
import com.jonathankim.monster_factory.size.Size;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MonsterServiceTests {

    @Autowired
    private MonsterServiceImpl monsterService;

    @Autowired
    MonsterRepository monsterRepository;

    @Autowired
    LocationRepository locationRepository;

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
    public void getAllMonstersReturnsListOfMonstersIfNotEmpty() {
        List<Monster> monsterList = monsterService.getAllMonsters();
        System.out.println(monsterList);

        assertThat(monsterList).asList().hasSize(1);
    }

    @Test
    public void saveMonsterPersistsMonsterObjectToDB() {
        Monster targetMonster = new Monster("testMon2");
        monsterService.saveMonster(targetMonster);

        assertThat(targetMonster).isEqualTo(monsterRepository.findMonsterByName("testMon2"));
    }

    @Test
    public void getMonsterByIdReturnsMonsterGivenValidId() {
        Monster targetMonster = monsterService.getMonsterById(monsterRepository.findMonsterByName("testMon").getId());

        assertThat(targetMonster).isNotNull();
    }

    @Test
    @Transactional
    public void deleteMonsterByIdReturnsNull() {
        monsterService.deleteMonsterById(monsterRepository.findMonsterByName("testMon").getId());

        assertThat(monsterRepository.findMonsterByName("testMon")).isNull();
    }
}
