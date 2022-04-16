package com.jonathankim.monster_factory.location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocations();
    Location getLocationById(long id);
    void saveLocation(Location location);
}
