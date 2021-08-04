package com.humanbooster.picom.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer startHour;

    private Integer endHour;

    public TimeSlot(Integer startHour, Integer endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public TimeSlot() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }
}
