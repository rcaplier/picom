package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TimeSlotDAO extends JpaRepository<TimeSlot, Long> {
    TimeSlot getTimeSlotByStartHourAndEndHour(Integer startHour, Integer endHour);
}
