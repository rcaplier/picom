package com.humanbooster.picom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Stop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Merci de renseigner le nom de l'arrêt.")
    private String name;

    @JsonIgnore
    @ManyToOne
    @NotNull(message = "Merci de préciser la zone.")
    private Area area;

    public Stop(String name, Area area) {
        this.name = name;
        this.area = area;
    }

    public Stop() {
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
