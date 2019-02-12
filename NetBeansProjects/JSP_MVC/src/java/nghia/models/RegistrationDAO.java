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
import nghia.dto.RegistrationDTO;
import nghia.dto.MyConnection;

/**
 *
 * @author mickw
 */
public class RegistrationDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public RegistrationDAO() {
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (preStm != null) {
                preStm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String CheckLogin(String username, String password) {
        String role = "failed";
        try {
            String sql = "Select Role from Registration where username =? and password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return role;
    }

    public List<RegistrationDTO> findByLikeName(String search) {
        List<RegistrationDTO> result = null;
        String username = null;
        String fullname = null;
        String role = null;
        RegistrationDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Role from Registration " + "where Fullname like ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                dto = new RegistrationDTO(username, fullname, role);
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean delete(String username) {
        boolean check = false;
        try {
            String sql = "Delete from Registration where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return check;
    }
    public RegistrationDTO findByPrimaryKey(String key){
        RegistrationDTO dto = null;
        try {
            String sql = "Select Fullname, role From Registration where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if(rs.next()){
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                dto = new RegistrationDTO(key, fullname, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return dto;
    }
    public boolean update(RegistrationDTO dto){
        boolean check = false;
        try {
            String sql = "Update Registration set Password = ?, Fullname = ?, Role = ?" + " Where username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getPassword());
            preStm.setString(2, dto.getFullname());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
    public boolean insert(RegistrationDTO dto){
        boolean check = false;
        try {
            String sql="Insert into Registration(Username, Password, Fullname, Role) "+ "values(?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            check= preStm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            closeConnection();
        }
        return check;
    }
}
