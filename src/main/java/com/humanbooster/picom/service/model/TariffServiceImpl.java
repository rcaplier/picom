package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.TariffDAO;
import com.humanbooster.picom.model.Area;
import com.humanbooster.picom.model.Tariff;
import com.humanbooster.picom.model.TimeSlot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    TariffDAO tariffDAO;

    public TariffServiceImpl(TariffDAO tariffDAO) {
        this.tariffDAO = tariffDAO;
    }

    @Override
    public Tariff saveTariff(Tariff tariff) {
        return tariffDAO.save(tariff);
    }

    @Override
    public Tariff getTariffById(Long id) {
        return tariffDAO.getById(id);
    }

    @Override
    public Tariff getTariffByAreaAndTimeSlot(Area area, TimeSlot timeSlot) {
        return tariffDAO.getTariffByAreaAndTimeSlot(area, timeSlot);
    }

    @Override
    public Page<Tariff> getTariffs(Pageable pageable) {
        return tariffDAO.findAll(pageable);
    }

    @Override
    public List<Tariff> getTariffs() {
        return tariffDAO.findAll();
    }
}
