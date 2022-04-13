package com.jonathankim.monster_factory.service;

import com.jonathankim.monster_factory.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocationById(long id);
    void saveLocation(Location location);
}
