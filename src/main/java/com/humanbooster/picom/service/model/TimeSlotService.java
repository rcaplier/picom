package com.humanbooster.picom.service.model;

import com.humanbooster.picom.model.TimeSlot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TimeSlotService {

    TimeSlot saveTimeSlot(TimeSlot timeSlot);

    TimeSlot getTimeSlotById(Long id);

    TimeSlot getTimeSlotByStartHourAndEndHour(Integer startHour,Integer endHour);

    Page<TimeSlot> getTimeSlots(Pageable pageable);

    List<TimeSlot> getTimeSlots();


}
