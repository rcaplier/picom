package com.humanbooster.picom.service.model;

import com.humanbooster.picom.dao.RoleDAO;
import com.humanbooster.picom.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }


    @Transactional
    @Override
    public Role saveRole(Role role) {
        return roleDAO.save(role);
    }

    @Override
    public Role getRoleByRole(String role) {
        return roleDAO.getRoleByRole(role);
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDAO.getById(id);
    }

    @Override
    public Page<Role> getRoles(Pageable pageable) {
        return roleDAO.findAll(pageable);
    }

    @Override
    public List<Role> getRoles() {
        return roleDAO.findAll();
    }
}
