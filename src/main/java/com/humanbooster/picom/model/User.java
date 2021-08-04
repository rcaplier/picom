package com.humanbooster.picom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Merci de renseigner votre nom.")
    private String firstName;

    @NotBlank(message = "Merci de renseigner votre prénom.")
    private String lastName;

    @JsonIgnore
    @Email(message = "Merci de saisir un email au bon format.")
    @NotBlank(message = "Merci de renseigner votre email.")
    private String mail;

    @JsonIgnore
    @NotBlank(message = "Merci de renseigner votre mot de passe.")
    @Size(min = 8, message = "Merci de saisir un mot de passe contenant au moins 8 caractères.")
    private String password;

    @JsonIgnore
    private Boolean isActive;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(Long id, String firstName, String lastName, String mail, String password, Boolean isActive, Set<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }

    public User(String firstName, String lastName, String mail, String password, Boolean isActive, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.isActive = isActive;
        this.roles = roles;
    }

    public User(String firstName, String lastName, String mail, String password, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.isActive = isActive;
    }

    public User(Long id){
        this.id = id;
    }

    public User() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
