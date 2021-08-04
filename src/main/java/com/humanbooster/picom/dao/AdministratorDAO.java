package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorDAO extends JpaRepository<Administrator, Long> {

    Administrator getAdministratorByMail(String mail);
}
