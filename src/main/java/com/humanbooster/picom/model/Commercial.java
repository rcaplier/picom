package com.humanbooster.picom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Commercial {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private LocalDateTime creationDate;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Area> areas;

    public Commercial(String title, LocalDateTime creationDate, LocalDateTime startDate, LocalDateTime endDate, Client client, List<Area> areas) {
        this.title = title;
        this.creationDate = creationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
        this.areas = areas;
    }

    public Commercial(Client client) {
        this.client = client;
    }

    public Commercial() {
    }

    public String getCreationDateFormated() {
        return getCreationDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy à hh:mm:ss"));
    }

    public String getStartDateFormated() {
        return getStartDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy à hh:mm:ss"));
    }
    public String getEndDateFormated() {
        return getEndDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy à hh:mm:ss"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Commercial{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
