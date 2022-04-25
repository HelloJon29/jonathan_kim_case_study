package com.jonathankim.monster_factory.monster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MonsterServiceImpl implements MonsterService {
    // instantiate MonsterRepository for DI
    private MonsterRepository monsterRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

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
        LOGGER.info("=== MONSTER SAVED TO DB ===");
    }

    @Override
    public Monster getMonsterById(long id) {
        Monster monster;
        try {
            monster = monsterRepository.findMonsterById(id);
            if(monster == null) {
                throw new NoSuchElementException();
            }
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
