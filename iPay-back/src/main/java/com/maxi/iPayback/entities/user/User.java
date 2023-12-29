package com.maxi.iPayback.entities.user;

import java.math.BigDecimal;

import com.maxi.iPayback.enums.UserType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String LastName;

    @Column(unique = true)
    private String personalId;

    @Column(unique = true)
    private String email;
    private String foneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;
    private BigDecimal sold;

    public User() {
    }

    public User(String firstName, String lastName, String personalId, String email, String foneNumber,
            UserType userType,
            BigDecimal sold) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.personalId = personalId;
        this.email = email;
        this.foneNumber = foneNumber;
        this.userType = userType;
        this.sold = sold;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoneNumber() {
        return foneNumber;
    }

    public void setFoneNumber(String foneNumber) {
        this.foneNumber = foneNumber;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public BigDecimal getSold() {
        return sold;
    }

    public void setSold(BigDecimal sold) {
        this.sold = sold;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
