package com.jonathankim.monster_factory.monster;

import com.jonathankim.monster_factory.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MonsterServiceImpl implements MonsterService {
    // instantiate MonsterRepository for DI
    private MonsterRepository monsterRepository;
    private UserService userService;
    @Autowired
    public MonsterServiceImpl(MonsterRepository monsterRepository, UserService userService) {
        this.monsterRepository = monsterRepository;
        this.userService = userService;
    }

    @Override
    public List<Monster> getAllMonsters() {
        return monsterRepository.findAll();
    } // add empty list exception
    @Override
    public void saveMonster(Monster monster) {
        monsterRepository.save(monster);
    } // add already exists exception

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
