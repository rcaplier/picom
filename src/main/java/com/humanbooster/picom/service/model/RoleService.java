package com.humanbooster.picom.service.model;

import com.humanbooster.picom.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    Role getRoleByRole(String role);

    Role getRoleById(Integer id);

    Page<Role> getRoles(Pageable pageable);

    List<Role> getRoles();
}
