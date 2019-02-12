/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nghia.connection.MyConnection;
import nghia.dto.RegistrationDTO;

/**
 *
 * @author mickw
 */
public class RegistrationDAO implements Serializable {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    private void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkLogin(String username, String password) {
        String role = "failed";
        try {
            String sql = "Select Role from Registration where username = ? and password = ?";
            conn = MyConnection.myConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                role = rs.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<RegistrationDTO> searchByFullnames(String search) {
        boolean proceed = false;
        List<RegistrationDTO> result = null;
        try {
            String sql = "Select Username, Password, fullname, role from Registration where Username like ?";
            conn = MyConnection.myConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            rs = ps.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                RegistrationDTO dto = new RegistrationDTO(username, role, fullname);
                dto.setPassword(password);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean Registry(RegistrationDTO dto) {
        boolean check = false;
        try {
            String sql = "Insert into Registration(Username, Password, Fullname, Role) values(?,?,?,?)";
            conn = MyConnection.myConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getFullname());
            ps.setString(4, dto.getRole());
            check = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean update(RegistrationDTO dto ) {
        boolean check = false;
        try {
            String sql = "Update Registration set Password = ?, Fullname = ?, Role = ? where username = ?";
            conn = MyConnection.myConnection();
            ps= conn.prepareStatement(sql);
            ps.setString(1, dto.getPassword());
            ps.setString(2, dto.getFullname());
            ps.setString(3, dto.getRole());
            ps.setString(4, dto.getUsername());
            check = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public RegistrationDTO searchByPrimarykey(String username){
        RegistrationDTO dto = null;
        try {
            String sql = "Select Fullname, Role from Registration where username = ?";
            conn = MyConnection.myConnection();
            ps=  conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while(rs.next()){
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                System.out.println(role);
                dto = new RegistrationDTO(username, role, fullname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean delete(String username) throws Exception{
        boolean check = false;
        String sql = "Delete from Registration where username  = ?";
        conn = MyConnection.myConnection();
        ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        check = ps.executeUpdate()> 0;
        return check;
    }
}
