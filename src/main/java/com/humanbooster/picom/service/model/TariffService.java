package com.humanbooster.picom.service.model;

import com.humanbooster.picom.model.Area;
import com.humanbooster.picom.model.Tariff;
import com.humanbooster.picom.model.TimeSlot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Time;
import java.util.List;

public interface TariffService {
    Tariff saveTariff(Tariff tariff);

    Tariff getTariffById(Long id);

    Tariff getTariffByAreaAndTimeSlot(Area area, TimeSlot timeSlot);

    Page<Tariff> getTariffs(Pageable pageable);

    List<Tariff> getTariffs();
}
