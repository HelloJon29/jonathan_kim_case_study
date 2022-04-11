package com.jonathankim.monster_factory.service;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(long id) {
        super("Could not find that Location ID: " + id);
    }
}
