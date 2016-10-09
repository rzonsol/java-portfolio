package org.elearning.portfolio;

/**
 * Created by rzonsol on 09.10.2016.
 */
public class Student {
    private String Login;
    private String Email;
    private String FirstName;
    private String LastName;
    private Integer id;

    public void setLogin(String Login) {
        this.Login = Login;
    }
    public String getLogin() {
        return Login;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getEmail() {
        return Email;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }
    public String getLastName() {
        return LastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
}
