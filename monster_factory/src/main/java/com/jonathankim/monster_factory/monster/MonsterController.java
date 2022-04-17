package com.jonathankim.monster_factory.monster;

import com.jonathankim.monster_factory.location.Location;
import com.jonathankim.monster_factory.security.UserService;
import com.jonathankim.monster_factory.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class MonsterController {
    // instantiate MonsterService class for DI
    private MonsterService monsterService;
    private LocationService locationService;
    private UserService userService;

    @Autowired
    public MonsterController(MonsterService monsterService, LocationService locationService, UserService userService) {
        this.monsterService = monsterService;
        this.locationService = locationService;
        this.userService = userService;
    }

    @GetMapping("/vault")
    public String getAllMonsters(Model model) {
        model.addAttribute("listMonsters", monsterService.getAllMonsters());
        return "vault";
    }

    @GetMapping("/showNewMonsterForm")
    public String showNewMonsterForm(Model model) {
        Monster monster = new Monster();
        List<Location> listLocations = locationService.getAllLocations();
        model.addAttribute("monster", monster);
        model.addAttribute("listLocations", listLocations);
        return "new_monster";
    }

    @PostMapping("/saveMonster")
    public String saveMonster(@ModelAttribute("monster")Monster monster) {
        monsterService.saveMonster(monster);
        return "redirect:/vault";
    }

    @GetMapping("/showFormForUpdate/{id}") // add location for update
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        Monster monster = monsterService.getMonsterById(id);
        List<Location> listLocations = locationService.getAllLocations();
        model.addAttribute("monster", monster);
        model.addAttribute("listLocations", listLocations);
        return "update_monster";
    }

    @GetMapping("/deleteMonster/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id) {
        monsterService.deleteMonsterById(id);
        return "redirect:/vault";
    }
}
