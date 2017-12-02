/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yofika
 */
public class MasukController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private JFXPasswordField inputpin;

    @FXML
    private JFXButton btnsignup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
    }
    @FXML
    private void login(javafx.event.ActionEvent event) {
        Connection conn;
    Statement pst;
    ResultSet rs;
    String sql;
    
        DBConnect DB = new DBConnect();
        DB.connectdb();
        conn = DB.conn;
        pst = DB.pst;                                      
                
        try {
            sql = "SELECT * FROM user WHERE password='"+inputpin.getText()+"'";
            rs = pst.executeQuery(sql);
            if(rs.next()){
                if(inputpin.getText().equals(rs.getString("password"))){
               
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("utama.fxml"));
                      
            
            Scene scene = new Scene(fxmlLoader.load());            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Home");
            stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
    
    @FXML
    private void signup(javafx.event.ActionEvent event) {
        try {
                //hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
                //Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("daftar.fxml"));
                Scene scene = new Scene (fxmlLoader.load());
                //create new stage (window), then set the new scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Daftar");
                stage.show();
            } catch (IOException e) {
                System.out.println("Failed to create new Window." + e);
    }
}
    }    
    

