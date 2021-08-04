package com.humanbooster.picom.service.config;

import com.humanbooster.picom.model.Role;
import com.humanbooster.picom.model.User;
import com.humanbooster.picom.service.model.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SpringUserDetailsService implements UserDetailsService {

    UserService userService;

    public SpringUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getUserByMail(s);
        List<GrantedAuthority> authorities = getUserAuthorities(user.getRoles());
        return buildUserForAuthentification(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthorities(Set<Role> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();

        for (Role role : userRoles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(authorities);
    }

    private UserDetails buildUserForAuthentification(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getMail(), user.getPassword(), user.getActive(), true, true, true, authorities);
    }
}
