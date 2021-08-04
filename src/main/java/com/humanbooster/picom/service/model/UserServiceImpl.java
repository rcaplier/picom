package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.AdministratorDAO;
import com.humanbooster.picom.dao.ClientDAO;
import com.humanbooster.picom.dao.UserDAO;
import com.humanbooster.picom.exception.EmailExistsException;
import com.humanbooster.picom.model.Administrator;
import com.humanbooster.picom.model.Client;
import com.humanbooster.picom.model.Role;
import com.humanbooster.picom.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    UserDAO userDAO;
    ClientDAO clientDAO;
    AdministratorDAO administratorDAO;
    PasswordEncoder passwordEncoder;
    RoleService roleService;


    public UserServiceImpl(UserDAO userDAO, ClientDAO clientDAO, AdministratorDAO administratorDAO, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userDAO = userDAO;
        this.clientDAO = clientDAO;
        this.administratorDAO = administratorDAO;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Transactional
    @Override
    public Client saveClient(Client client) {
        return clientDAO.save(client);
    }

    @Transactional
    @Override
    public Administrator saveAdministrator(Administrator administrator) {
        return administratorDAO.save(administrator);
    }

    public boolean emailAlreadyExist(String email){
        User user = userDAO.getUserByMail(email);
        return user != null;
    }

    public Administrator registerNewAdministratorAccount(Administrator administrator) throws EmailExistsException {
        Set<Role> roles = new HashSet<>();
        Role role = roleService.getRoleByRole("administrator");
        roles.add(role);
        administrator.setRoles(roles);
        administrator.setPassword(passwordEncoder.encode(administrator.getPassword()));
        return administratorDAO.save(administrator);
    }

    public Client registerNewClientAccount(Client client) throws EmailExistsException {
        if (clientDAO.getClientByMail(client.getMail()) != null) {
            throw new EmailExistsException(
                    "There is an account with that email adress:" + client.getMail());
        }
        Set<Role> roles = new HashSet<>();
        Role role = roleService.getRoleByRole("client");
        roles.add(role);
        client.setRoles(roles);
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientDAO.save(client);
    }

    @Override
    public User getUserByMailAndPassword(String mail, String password) {
        return userDAO.getUserByMailAndPassword(mail, password);
    }

    @Override
    public User getUserByMail(String email) {
        return userDAO.getUserByMail(email);
    }

    @Override
    public Client getClientByMail(String email) {
        return clientDAO.getClientByMail(email);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userDAO.findAll(pageable);
    }

    @Override
    public Page<User> getUsersFilteredByFirstName(Pageable pageable, String firstNameFilter) {
        return userDAO.findUsersByFirstName(pageable, firstNameFilter);
    }

    @Override
    public Page<User> getUsersFilteredByLastName(Pageable pageable, String lastNameFilter) {
        return userDAO.findUsersByLastName(pageable, lastNameFilter);
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

    @Override
    public List<Administrator> getAdministrators() {
        return administratorDAO.findAll();
    }

    @Override
    public List<Client> getClients() {
        return clientDAO.findAll();
    }

    @Override
    public long countNbUsers() {
        return userDAO.count();
    }


}
