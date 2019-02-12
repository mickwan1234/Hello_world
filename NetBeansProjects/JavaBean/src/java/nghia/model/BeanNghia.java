/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.model;

import java.io.Serializable;

/**
 *
 * @author mickw
 */
public class BeanNghia implements Serializable {

    private String username, password;

    public BeanNghia() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkLogin() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.checkLogin(username, password);
    }
}
