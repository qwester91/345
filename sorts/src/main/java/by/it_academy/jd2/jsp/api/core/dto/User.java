package by.it_academy.jd2.jsp.api.core.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String login;
    private String password;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDateTime dateOfRegistration;
    private Roles role;

    public User() {
    }

    public User(String login, String password, String name, LocalDate dateOfBirth) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = LocalDateTime.now();
        this.role = Roles.USER;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDateTime dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
