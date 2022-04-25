package com.jonathankim.monster_factory.location;

import com.jonathankim.monster_factory.location.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationController {
    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/showLocations")
    public String showLocations(Model model) {
        model.addAttribute("listLocations", locationService.getAllLocations());
        return "location";
    }
}
