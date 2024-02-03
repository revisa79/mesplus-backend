package io.paradigm.mesplusbackend.models;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String userName;
    public String password;
    public boolean active;
    public String roles;

    public int getUserID() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public void setUserID(int userID) {
        this.id = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.password = passWord;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
