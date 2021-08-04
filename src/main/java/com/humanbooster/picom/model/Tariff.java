package com.humanbooster.picom.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double price;

    @ManyToOne
    private Area area;

    @ManyToOne
    private TimeSlot timeSlot;

    public Tariff(Double price, Area area, TimeSlot timeSlot) {
        this.price = price;
        this.area = area;
        this.timeSlot = timeSlot;
    }

    public Tariff(Double price, TimeSlot timeSlot) {
        this.price = price;
        this.timeSlot = timeSlot;
    }

    public Tariff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}
