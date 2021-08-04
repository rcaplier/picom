package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.AreaDAO;
import com.humanbooster.picom.model.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    AreaDAO areaDAO;

    public AreaServiceImpl(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }


    @Override
    public Area saveArea(Area area) {
        return areaDAO.save(area);
    }

    @Override
    public Area getAreaByName(String name) {
        return areaDAO.getAreaByName(name);
    }

    @Override
    public Area getAreaById(Long id) {
        return areaDAO.getById(id);
    }

    @Override
    public Page<Area> getAreas(Pageable pageable) {
        return areaDAO.findAll(pageable);
    }

    @Override
    public List<Area> getAreas() {
        return areaDAO.findAll();
    }

    @Secured({"administrator"})
    @Transactional
    @Override
    public void deleteArea(Area area) {
        areaDAO.delete(area);
    }
}
