package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.StopDAO;
import com.humanbooster.picom.model.Stop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopServiceImpl implements StopService {

    StopDAO stopDAO;

    public StopServiceImpl(StopDAO stopDAO) {
        this.stopDAO = stopDAO;
    }

    @Override
    public Stop saveStop(Stop stop) {
        return stopDAO.save(stop);
    }

    @Override
    public Stop getStopById(Long id) {
        return stopDAO.getById(id);
    }

    @Override
    public Page<Stop> getStops(Pageable pageable) {
        return stopDAO.findAll(pageable);
    }

    @Override
    public List<Stop> getStops() {
        return stopDAO.findAll();
    }
}
