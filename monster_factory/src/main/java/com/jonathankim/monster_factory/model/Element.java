package com.jonathankim.monster_factory.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String element;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "element_id")
    private List<Monster> monsterList;
}
