package com.humanbooster.picom.model;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class HTMLCommercial extends Commercial {
    private String content;

    public HTMLCommercial(String title, LocalDateTime creationDate, LocalDateTime startDate, LocalDateTime endDate, Client client, List<Area> areas, String content) {
        super(title, creationDate, startDate, endDate, client, areas);
        this.content = content;
    }

    public HTMLCommercial() {
        super();
    }
}
