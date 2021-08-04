package com.humanbooster.picom.service.model;

import com.humanbooster.picom.model.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AreaService {
    Area saveArea(Area area);

    Area getAreaByName(String name);

    Area getAreaById(Long id);

    Page<Area> getAreas(Pageable pageable);

    List<Area> getAreas();

    void deleteArea(Area area);
}
