package com.jonathankim.monster_factory.location;

import com.jonathankim.monster_factory.monster.Monster;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;

    public Location() {
    }

    public Location(String country) {
        this.country = country;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return id == location.id && Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country);
    }
}
