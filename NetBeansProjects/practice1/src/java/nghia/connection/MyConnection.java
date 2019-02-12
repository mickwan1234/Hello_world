/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nghia.connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mickw
 */
public class MyConnection {
    public static Connection myConnection(){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;" + " databaseName= SinhVien;"+
                    " user=sa; password=1234";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
