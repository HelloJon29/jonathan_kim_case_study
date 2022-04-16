package com.jonathankim.monster_factory.vault;

import javax.persistence.*;
import java.util.List;
@Entity
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //Getter and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
