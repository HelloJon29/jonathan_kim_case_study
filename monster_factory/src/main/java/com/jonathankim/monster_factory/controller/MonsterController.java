package com.jonathankim.monster_factory.controller;

import com.jonathankim.monster_factory.model.Monster;
import com.jonathankim.monster_factory.service.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MonsterController {
    // instantiate MonsterService class for DI
    private MonsterService monsterService;
    @Autowired
    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping("/index")
    public String showIndex() {
        return "/";
    }

    @GetMapping("/vault")
    public String getAllMonsters(Model model) {
        model.addAttribute("listMonsters", monsterService.getAllMonsters());
        return "vault";
    }

    @GetMapping("/showNewMonsterForm")
    public String showNewMonsterForm(Model model) {
        Monster monster = new Monster();
        model.addAttribute("monster", monster);
        return "new_monster";
    }

    @PostMapping("/saveMonster")
    public String saveMonster(@ModelAttribute("monster")Monster monster) {
        monsterService.saveMonster(monster);
        return "redirect:/vault";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Monster monster = monsterService.getMonsterById(id);
        model.addAttribute("monster", monster);
        return "update_monster";
    }

    @GetMapping("/deleteMonster/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id) {
        monsterService.deleteMonsterById(id);
        return "redirect:/vault";
    }

}
