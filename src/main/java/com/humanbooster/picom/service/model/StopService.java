package com.humanbooster.picom.service.model;

import com.humanbooster.picom.model.Stop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StopService {

    Stop saveStop(Stop stop);

    Stop getStopById(Long id);

    Page<Stop> getStops(Pageable pageable);

    List<Stop> getStops();
}
