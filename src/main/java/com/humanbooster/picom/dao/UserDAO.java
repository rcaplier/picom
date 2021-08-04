package com.humanbooster.picom.dao;

import com.humanbooster.picom.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User, Long> {

    @Query("FROM User WHERE mail = :mail AND password = :password")
    User getUserByMailAndPassword(@Param("mail") String mail, @Param("password") String password);

    User getUserByMail(String mail);

    Page<User> findUsersByLastName(Pageable pageable, String lastName);

    Page<User> findUsersByFirstName(Pageable pageable, String lastName);
}
