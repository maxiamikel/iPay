package com.maxi.iPayback.dtos;

import java.math.BigDecimal;

import com.maxi.iPayback.entities.user.User;
import com.maxi.iPayback.enums.UserType;

public class UserDTO {

    private Long id;

    private String firstName;
    private String LastName;
    private String personalId;
    private String email;
    private String foneNumber;
    private UserType userType;
    private BigDecimal sold;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        this.firstName = obj.getFirstName();
        LastName = obj.getLastName();
        this.personalId = obj.getPersonalId();
        this.email = obj.getEmail();
        this.foneNumber = obj.getFoneNumber();
        this.userType = obj.getUserType();
        this.sold = obj.getSold();
    }

    public UserDTO(String firstName, String lastName, String personalId, String email, String foneNumber,
            UserType userType) {
        this.firstName = firstName;
        LastName = lastName;
        this.personalId = personalId;
        this.email = email;
        this.foneNumber = foneNumber;
        this.userType = userType;
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

}
