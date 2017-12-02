/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Yofika
 */
public class conf {
    private static Connection mysqlconfig;
    public static Connection configDB() throws SQLException{
        try{
            String url="jdbc:mysql://localhost:3306/money_manager";
            String user = "root";
            String pass="";
            mysqlconfig=(Connection) DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.err.println("koneksi gagal"+e.getMessage());
        }
        return mysqlconfig;
    }
}
