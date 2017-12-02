/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;

import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Yofika
 */
public class UtamaController implements Initializable {

    @FXML
    private DatePicker idtanggal;
     @FXML
    private JFXTextField idkategori;

    @FXML
    private JFXTextField idpemasukan;

    @FXML
    private JFXTextField idpengeluaran;

    @FXML
    private TableView<data> tabel;

    @FXML
    private TableColumn<data, String> coldate;

    @FXML
    private TableColumn<data, String> pemasukan;

    @FXML
    private TableColumn<data, String> pengeluaran;

    @FXML
    private TableColumn<data, String> kategori;
    
    private conf dc;
    private ObservableList<data>data;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void proses(javafx.event.ActionEvent event) {
        try{
            String sql= "INSERT INTO keungangan (tanggal, pemasukan, pengeluaran, kategori) VALUES " + "('"+idtanggal.getValue()+"','"+idpemasukan.getText()+"','"+idpengeluaran.getText()
                    +"','"+idkategori.getText()+"','";
            java.sql.Connection conn=(Connection)conf.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Save Succes");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Penyimpanan Gagal"+ e.getMessage());
        }
        
    }
    @FXML
    private void history (javafx.event.ActionEvent event) {
        Connection con;
        Statement stat;
        
        
        DBConnect DB = new DBConnect();
        DB.connectdb();
        con = DB.conn;
        stat = (Statement) DB.pst;
        try{
            data = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM keuangan");
            while (rs.next()){
                data.add(new data(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        coldate.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        pemasukan.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        pengeluaran.setCellValueFactory(new PropertyValueFactory<>("pemasukan"));
        kategori.setCellValueFactory(new PropertyValueFactory<>("pengeluaran"));
        

        tabel.setItems(null);
        tabel.setItems(data);
    }

    
    @FXML
    private void hapus (javafx.event.ActionEvent event) {
       
          idkategori.setText("");
          idpemasukan.setText("");
          idpengeluaran.setText("");

    }
}