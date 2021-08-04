package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.ClientDAO;
import com.humanbooster.picom.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

    private ClientDAO clientDAO;

    public ClientServiceImpl(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }


    @Override
    public Client getClientById(Long id) {
        return clientDAO.getById(id);
    }
}
