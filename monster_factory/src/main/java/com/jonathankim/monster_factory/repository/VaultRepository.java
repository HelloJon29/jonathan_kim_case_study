package com.jonathankim.monster_factory.repository;

import com.jonathankim.monster_factory.model.Vault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaultRepository extends JpaRepository<Vault, Long> {

}
