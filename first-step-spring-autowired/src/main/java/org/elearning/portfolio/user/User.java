package org.elearning.portfolio.user;

/**
 * Created by rzonsol on 09.10.2016.
 */
public class User {

    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private Integer id;

    public void setLogin(String login) {
        this.login = login;
    }
    public String getLogin() {
        return login;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public String getFullName(){return this.firstName +" "+ this.lastName;}
}
