package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<Client, Long> {
    Client getClientByMail(String mail);
}
