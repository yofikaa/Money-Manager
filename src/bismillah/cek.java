/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;

import java.sql.SQLException;

/**
 *
 * @author Yofika
 */
public class cek {
    public static void main(String [] args) throws SQLException {
    DBConnect connection = new DBConnect();
    connection.connectdb();
}
}
