package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//here don't use class name as User as it will conflict with some databases
@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private long userId;

    @Email(message = "email should be in proper form")
    @NotBlank(message = "email should be blank")
    private String email;

    @NotBlank(message = "First name should be blank")
    private String firstName;

    @NotBlank(message = "Last name should be blank")
    private String lastName;

    public AppUser() {
        // jpa
    }

    public AppUser(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User [userId=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
                + "]";
    }

}
