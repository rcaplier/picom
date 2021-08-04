package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Commercial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommercialDAO extends JpaRepository<Commercial, Long> {

    List<Commercial> findByClient(Client client);

    List<Commercial> findByClientAndStartDateBetween(Client client, LocalDateTime dateDebut, LocalDateTime dateFin);

    Page<Commercial> findByClient(Pageable pageable, Client client);

}
