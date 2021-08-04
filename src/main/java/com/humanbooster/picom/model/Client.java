package com.humanbooster.picom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class Client extends User {


    @Column(length = 15) // Contrainte sur la colonne
    @Size(max = 15) // Contrainte métier
    private String phoneNumber;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Commercial> commercials;

    public Client(String firstName, String lastName, String mail, String password, String phoneNumber, Boolean isActive, Set<Role> roles) {
        super(firstName, lastName, mail, password, isActive, roles);
        this.phoneNumber = phoneNumber;
    }

    public Client(String firstName, String lastName, String mail, String password, String phoneNumber, Boolean isActive) {
        super(firstName, lastName, mail, password, isActive);
        this.phoneNumber = phoneNumber;
    }

    public Client() {
        super();
    }

    public Client(Long id){
        super(id);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Commercial> getCommercials() {
        return commercials;
    }

    public void setCommercials(List<Commercial> commercials) {
        this.commercials = commercials;
    }

    @Override
    public boolean equals(Object obj) {
        if (! super.equals(obj)) {
            return false;
        }
        Client client = (Client) obj;
        if (super.getId().equals(client.getId())){  // added fields are tested
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + super.getId() + '\'' +
                "firstName='" + super.getFirstName() + '\'' +
                "lastName='" + super.getLastName() + '\'' +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
