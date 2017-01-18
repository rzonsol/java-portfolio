package org.elearning.portfolio.user;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rzonsol on 09.10.2016.
 */
@Entity
@Table(name ="USER")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name ="LOGIN")
    private String login;

    @Column(name = "EMAiL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="USER_ID")
    private List<Role> roles = new ArrayList<Role>();

    public User(){}

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

    public List<Role> getRoles() {return roles;}
    public void setRoles(List<Role> roles) {this.roles = roles;}
    public String getRolesToString(){
        String stringRoles="";
        Integer i=0;
        for (Role role:this.roles) {
            if (i!=0){
                stringRoles+=(","+role.getRoleName());
            }else{
                stringRoles+=role.getRoleName();
                i++;
            }
        }
        return stringRoles;
    }

public String getFullName(){return this.firstName +" "+ this.lastName;}
}