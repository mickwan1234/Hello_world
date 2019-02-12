/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.dto;

import java.io.Serializable;

/**
 *
 * @author mickw
 */
public class RegistrationDTO implements Serializable{
    String username, password, role, fullname;

    public RegistrationDTO(String username, String role, String fullname) {
        this.username = username;
        this.role = role;
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" + "username=" + username + ", password=" + password + ", role=" + role + ", fullname=" + fullname + '}';
    }
    
}
