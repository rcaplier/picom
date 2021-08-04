package com.humanbooster.picom.model;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class Administrator extends User {

    public Administrator(String nom, String prenom, String email, String motDePasse, Boolean isActive, Set<Role> roles) {
        super(nom, prenom, email, motDePasse, isActive, roles);
    }

    public Administrator() {
        super();
    }

    public Administrator(String firstName, String lastName, String mail, String password, Boolean isActive) {
        super(firstName, lastName, mail, password, isActive);
    }
}
