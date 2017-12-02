/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yofika
 */
public class DaftarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField inputusername;
    @FXML
    private JFXPasswordField inputpin;
    @FXML
    private JFXButton btnsignup;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void signup(javafx.event.ActionEvent event) throws IOException {
        if(inputusername.getText().equals("")||inputpin.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi data yang tertera");
        }
        else{
        try {
            String sql = "INSERT INTO user VALUES('"+inputusername.getText()+"', '"+inputpin.getText()+"')";
            java.sql.Connection conn=(Connection)conf.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            
             ((Node)(event.getSource())).getScene().getWindow().hide();
                    // Load the new fxml
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("login.fxml"));
                    Scene scene = new Scene((Parent) fxmlLoader.load());

                    // Create new stage (window), then set the new Scene
                    Stage stage = new Stage();
                    stage.setResizable(false);
                    stage.setScene(scene);
                    stage.setTitle("Login");
                    stage.show();
            
           
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }
    @FXML
     private void back(javafx.event.ActionEvent event) {
        try {
                //hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
                //Load the new fxml
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("login.fxml"));
                Scene scene = new Scene (fxmlLoader.load());
                //create new stage (window), then set the new scene
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Login");
                stage.show();
            } catch (IOException e) {
                System.out.println("Failed to create new Window." + e);
    }
}
}
