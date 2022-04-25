package com.jonathankim.monster_factory.location_tests;

import com.jonathankim.monster_factory.location.Location;
import com.jonathankim.monster_factory.location.LocationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationRepositoryUnitTests {
    @Autowired
    private LocationRepository locationRepository;

    @Test
    public void findByCountryShouldReturnNullGivenInvalidValue() {
        Location location = locationRepository.findByCountry("jack");
        Location location1 = new Location("ITALY");

        locationRepository.save(location1);

        System.out.println(locationRepository.findByCountry("ITALY").getCountry());

        assertThat(location).isEqualTo(null);
    }

    @Test
    public void findByCountryShouldReturnCountryGivenValidValue() {
        Location location = locationRepository.findByCountry("USA");
        assertThat(location.getCountry()).isEqualTo("USA");
    }


}
