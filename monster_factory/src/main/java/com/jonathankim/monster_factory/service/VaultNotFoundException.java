package com.jonathankim.monster_factory.service;

public class VaultNotFoundException extends RuntimeException {
    public VaultNotFoundException(long id) {
        super("Could not find Vault ID: " + id);
    }
}
