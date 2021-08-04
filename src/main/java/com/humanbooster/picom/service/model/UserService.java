package com.humanbooster.picom.service.model;

import com.humanbooster.picom.model.Administrator;
import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    Client saveClient(Client client);

    Administrator saveAdministrator(Administrator administrator);

    User getUserByMailAndPassword(String email, String motDePasse);

    User getUserByMail(String email);

    Client getClientByMail(String email);

    Page<User> getUsers(Pageable pageable);

    Page<User> getUsersFilteredByFirstName(Pageable pageable, String firstNameFilter);

    Page<User> getUsersFilteredByLastName(Pageable pageable, String lastNameFilter);

    List<User> getUsers();

    List<Administrator> getAdministrators();

    List<Client> getClients();

    long countNbUsers();

}