package com.jonathankim.monster_factory.repository;

import com.jonathankim.monster_factory.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonsterRepository extends JpaRepository<Monster, Long> {

}
