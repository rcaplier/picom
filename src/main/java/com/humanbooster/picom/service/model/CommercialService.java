package com.humanbooster.picom.service.model;


import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Commercial;
import com.humanbooster.picom.model.HTMLCommercial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommercialService {

    Commercial saveCommercial(Commercial commercial);

    Commercial getCommercialById(Long id);

    HTMLCommercial saveHTMLCommercial(HTMLCommercial htmlCommercial);

    Page<Commercial> getCommercialsByClient(Client client, Pageable pageable);

    List<Commercial> getCommercialsByClient(Client client);

    List<Commercial> getCommercials();

    long countNbCommercials();
}
