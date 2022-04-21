package com.jonathankim.monster_factory.controller;

import com.jonathankim.monster_factory.color.Color;
import com.jonathankim.monster_factory.color.ColorService;
import com.jonathankim.monster_factory.location.Location;
import com.jonathankim.monster_factory.location.LocationService;
import com.jonathankim.monster_factory.monster.Monster;
import com.jonathankim.monster_factory.monster.MonsterService;
import com.jonathankim.monster_factory.size.Size;
import com.jonathankim.monster_factory.size.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonsterRestController {

    private MonsterService monsterService;
    private LocationService locationService;
    private SizeService sizeService;
    private ColorService colorService;


    @Autowired
    public MonsterRestController(MonsterService monsterService, LocationService locationService, SizeService sizeService, ColorService colorService) {
        this.monsterService = monsterService;
        this.locationService = locationService;
        this.sizeService = sizeService;
        this.colorService = colorService;
    }

    @GetMapping("/listMonsters")
    public List<Monster> getAllMonsters() {
        return monsterService.getAllMonsters();
    }

    @PostMapping("/listMonsters")
    public Monster newMonster(@RequestBody Monster monster) {
        monsterService.saveMonster(monster);
        return monster;
    }
}
