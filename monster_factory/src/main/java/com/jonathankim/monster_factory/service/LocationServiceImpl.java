package com.jonathankim.monster_factory.service;

import com.jonathankim.monster_factory.model.Location;
import com.jonathankim.monster_factory.model.Monster;
import com.jonathankim.monster_factory.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocationServiceImpl implements LocationService{
    private LocationRepository locationRepository;
    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationById(long id) {
        Location location;

        try {
           location = locationRepository.getById(id);
        } catch(NoSuchElementException e) {
            throw new LocationNotFoundException(id);
        }
        return location;
    }
}
