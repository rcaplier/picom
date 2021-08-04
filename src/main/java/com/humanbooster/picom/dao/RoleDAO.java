package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Integer> {

    Role getRoleByRole(String role);
}
