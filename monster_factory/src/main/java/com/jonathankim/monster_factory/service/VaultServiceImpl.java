package com.jonathankim.monster_factory.service;

import com.jonathankim.monster_factory.model.Vault;
import com.jonathankim.monster_factory.repository.VaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class VaultServiceImpl implements VaultService{
    private VaultRepository vaultRepository;
    @Autowired
    public VaultServiceImpl(VaultRepository vaultRepository) {
        this.vaultRepository = vaultRepository;
    }

    @Override
    public Vault getVaultById(long id) {
        Vault vault;

        try {
            vault = vaultRepository.getById(id);
        } catch(NoSuchElementException e) {
            throw new VaultNotFoundException(id);
        }
        return vault;
    }
}
