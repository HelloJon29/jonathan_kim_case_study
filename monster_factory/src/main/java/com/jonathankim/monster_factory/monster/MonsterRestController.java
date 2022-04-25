package com.jonathankim.monster_factory.controller;

import com.jonathankim.monster_factory.color.ColorService;
import com.jonathankim.monster_factory.location.LocationService;
import com.jonathankim.monster_factory.monster.Monster;
import com.jonathankim.monster_factory.monster.MonsterRepository;
import com.jonathankim.monster_factory.monster.MonsterService;
import com.jonathankim.monster_factory.size.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MonsterRestController {

    private MonsterService monsterService;
    private MonsterRepository monsterRepository;
    private LocationService locationService;
    private SizeService sizeService;
    private ColorService colorService;


    @Autowired
    public MonsterRestController(MonsterService monsterService, MonsterRepository monsterRepository, LocationService locationService, SizeService sizeService, ColorService colorService) {
        this.monsterService = monsterService;
        this.monsterRepository = monsterRepository;
        this.locationService = locationService;
        this.sizeService = sizeService;
        this.colorService = colorService;
    }

    @GetMapping("/monsters")
    public List<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @PostMapping("/monsters")
    public Monster newMonster(@RequestBody Monster monster) {
        monsterService.saveMonster(monster);
        return monster;
    }

    @GetMapping("/monsters/{id}")
    Monster getMonsterById(@PathVariable Long id) {
        return monsterRepository.findById(id).get();
    }
    @PutMapping("/monsters/{id}")
    Monster updateMonster(@RequestBody Monster monster, @PathVariable Long id) {
        return monsterRepository.findById(id).map(employee -> {
            monster.setName(monster.getName());
            monster.setColor(monster.getColor());
            monster.setSize(monster.getSize());
            monster.setLocation(monster.getLocation());
            return monsterRepository.save(monster);
        }).orElseGet(() -> {
            monster.setId(id);
            return monsterRepository.save(monster);
        });
    }

    @DeleteMapping("/monsters/{id}")
    void deleteMonster(@PathVariable Long id) {
        monsterRepository.deleteById(id);
    }
}
