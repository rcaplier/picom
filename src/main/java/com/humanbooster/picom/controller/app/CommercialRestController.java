package com.humanbooster.picom.controller.app;

import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Commercial;
import com.humanbooster.picom.service.model.ClientServiceImpl;
import com.humanbooster.picom.service.model.CommercialServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/app/annonces/"})
public class CommercialRestController {

    private ClientServiceImpl clientService;
    private CommercialServiceImpl commercialService;
    private static final Logger logger = LogManager.getLogger(Logger.class.getName());

    public CommercialRestController(ClientServiceImpl clientService, CommercialServiceImpl commercialService) {
        this.clientService = clientService;
        this.commercialService = commercialService;
    }

    @GetMapping("commercials/{idClient}")
    public Page<Commercial> getClientCommercials(@PathVariable Long idClient, Pageable pageable){
        logger.log(Level.INFO,"Demande API commercials/{idClient}");
        Client client = clientService.getClientById(idClient);
        return commercialService.getCommercialsByClient(client, pageable);
    }
}
