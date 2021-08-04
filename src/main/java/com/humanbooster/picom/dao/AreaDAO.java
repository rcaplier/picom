package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaDAO extends JpaRepository<Area, Long> {
    Area getAreaByName(String name);
}
