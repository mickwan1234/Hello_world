/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mickw
 */
public class RegistrationDAO implements Serializable {

    public RegistrationDAO() {

    }

    public String checkLogin(String username, String password) throws Exception {
        String role = "failed";
        String url = "jdbc:sqlserver://localhost:1433;" + " databaseName= SinhVien;"
                + " user=sa; password=1234";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String sql = "Select Role from Registration where Username = ? and Password = ?";
        try (
                Connection conn = DriverManager.getConnection(url);
                PreparedStatement preStm = conn.prepareStatement(sql);) {
            preStm.setString(1, username);
            preStm.setString(2, password);
            try (ResultSet rs = preStm.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("Role");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
}
