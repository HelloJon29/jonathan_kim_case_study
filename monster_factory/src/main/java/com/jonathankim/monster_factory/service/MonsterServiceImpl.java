package com.jonathankim.monster_factory.service;

import com.jonathankim.monster_factory.model.Monster;
import com.jonathankim.monster_factory.repository.MonsterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MonsterServiceImpl implements MonsterService {
    // instantiate MonsterRepository for DI
    private MonsterRepository monsterRepository;
    @Autowired
    public MonsterServiceImpl(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    }
    @Override
    public void saveMonster(Monster monster) {
        monsterRepository.save(monster);
    }

    @Override
    public Monster getMonsterById(long id) {
        Monster monster;

        try {
            monster = monsterRepository.getById(id);
        } catch(NoSuchElementException e) {
            throw new MonsterNotFoundException(id);
        }
        return monster;
    }

    @Override
    public void deleteMonsterById(long id) {
        monsterRepository.deleteById(id);
    }
}
