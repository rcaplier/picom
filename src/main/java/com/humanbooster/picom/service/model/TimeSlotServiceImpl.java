package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.TimeSlotDAO;
import com.humanbooster.picom.model.TimeSlot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSlotServiceImpl implements TimeSlotService {
    TimeSlotDAO timeSlotDAO;

    public TimeSlotServiceImpl(TimeSlotDAO timeSlotDAO) {
        this.timeSlotDAO = timeSlotDAO;
    }


    @Override
    public TimeSlot saveTimeSlot(TimeSlot timeSlot) {
        return timeSlotDAO.save(timeSlot);
    }

    @Override
    public TimeSlot getTimeSlotById(Long id) {
        return timeSlotDAO.getById(id);
    }

    @Override
    public TimeSlot getTimeSlotByStartHourAndEndHour(Integer startHour, Integer endHour) {
        return timeSlotDAO.getTimeSlotByStartHourAndEndHour(startHour, endHour);
    }

    @Override
    public Page<TimeSlot> getTimeSlots(Pageable pageable) {
        return timeSlotDAO.findAll(pageable);
    }

    @Override
    public List<TimeSlot> getTimeSlots() {
        return timeSlotDAO.findAll();
    }
}
