package com.humanbooster.picom.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "area")
    private List<Stop> stops;

    @ManyToMany(mappedBy = "areas", fetch = FetchType.EAGER)
    private List<Commercial> commercials;

    public Area(String name) {
        this.name = name;
    }

    public Area(String name, List<Stop> stops, List<Commercial> commercials) {
        this.name = name;
        this.stops = stops;
        this.commercials = commercials;
    }

    public Area() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public List<Commercial> getCommercials() {
        return commercials;
    }

    public void setCommercials(List<Commercial> commercials) {
        this.commercials = commercials;
    }

}
