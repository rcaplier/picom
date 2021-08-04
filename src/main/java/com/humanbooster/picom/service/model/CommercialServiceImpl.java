package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.CommercialDAO;
import com.humanbooster.picom.dao.HTMLCommercialDAO;
import com.humanbooster.picom.dao.PictureCommercialDAO;
import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Commercial;
import com.humanbooster.picom.model.HTMLCommercial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommercialServiceImpl implements CommercialService {

    private CommercialDAO commercialDAO;
    private HTMLCommercialDAO htmlCommercialDAO;
    private PictureCommercialDAO pictureCommercialDAO;

    public CommercialServiceImpl(CommercialDAO commercialDAO, HTMLCommercialDAO htmlCommercialDAO, PictureCommercialDAO pictureCommercialDAO) {
        this.commercialDAO = commercialDAO;
        this.htmlCommercialDAO = htmlCommercialDAO;
        this.pictureCommercialDAO = pictureCommercialDAO;
    }

    @Override
    public Commercial saveCommercial(Commercial commercial) {
        return commercialDAO.save(commercial);
    }

    @Override
    public Commercial getCommercialById(Long id) {
        return commercialDAO.getById(id);
    }

    @Override
    public HTMLCommercial saveHTMLCommercial(HTMLCommercial htmlCommercial) {
        return htmlCommercialDAO.save(htmlCommercial);
    }

    @Override
    public Page<Commercial> getCommercialsByClient(Client client, Pageable pageable) {
        return commercialDAO.findByClient(pageable, client);
    }

    @Override
    public List<Commercial> getCommercialsByClient(Client client) {
        return commercialDAO.findByClient(client);
    }

    @Override
    public List<Commercial> getCommercials() {
        return commercialDAO.findAll();
    }

    @Override
    public long countNbCommercials() {
        return commercialDAO.count();
    }
}
