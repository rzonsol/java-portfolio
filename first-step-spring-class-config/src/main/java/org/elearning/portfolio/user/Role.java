package org.elearning.portfolio.user;

import javax.persistence.*;

@Entity
@Table(name = "ROLES")
public class Role{
    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name ="USER_ID")
    private Integer userId;

    public Role(){}

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserId() {return userId;}

    public void setUserId(Integer userId) {this.userId = userId;}

}