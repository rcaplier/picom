package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.Area;
import com.humanbooster.picom.model.Tariff;
import com.humanbooster.picom.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffDAO extends JpaRepository<Tariff, Long> {
    Tariff getTariffByAreaAndTimeSlot(Area area, TimeSlot timeSlot);
}
