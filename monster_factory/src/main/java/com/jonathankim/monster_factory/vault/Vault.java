package com.jonathankim.monster_factory.vault;

import com.jonathankim.monster_factory.monster.Monster;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
//    @ManyToMany(mappedBy = "vault")
//    private List<Monster> monsterList = new ArrayList<>();


    //Getter and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public List<Monster> getMonsterList() {
//        return monsterList;
//    }
//
//    public void setMonsterList(List<Monster> monsterList) {
//        this.monsterList = monsterList;
//    }
}
