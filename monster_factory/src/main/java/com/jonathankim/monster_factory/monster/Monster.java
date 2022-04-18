package com.jonathankim.monster_factory.monster;

import com.jonathankim.monster_factory.color.Color;
import com.jonathankim.monster_factory.location.Location;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Monsters")
public class Monster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 25, message = "Your Monster's name must be less than 25 characters")
    @Column(name = "monster_name", length = 25, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id")
    private com.jonathankim.monster_factory.size.Size size;
    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Location location;

    // Getters Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.jonathankim.monster_factory.size.Size getSize() {
        return size;
    }

    public void setSize(com.jonathankim.monster_factory.size.Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
