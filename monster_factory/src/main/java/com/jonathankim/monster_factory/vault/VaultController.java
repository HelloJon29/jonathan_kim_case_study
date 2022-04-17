package com.jonathankim.monster_factory.vault;

import com.jonathankim.monster_factory.monster.MonsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VaultController {
    private VaultService vaultService;
    private MonsterService monsterService;

    @Autowired
    public VaultController(VaultService vaultService, MonsterService monsterService) {
        this.vaultService = vaultService;
        this.monsterService = monsterService;
    }

    @GetMapping("/vault/{id}")
    public String displayVault(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("vault", vaultService.getVaultById(id));
        model.addAttribute("listMonsters", monsterService.getAllMonsters());
        return "vault";
    }
}
