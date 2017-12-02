/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Yofika
 */
public class data {
    private final StringProperty tanggal;
    private final StringProperty kategori;
    private final StringProperty pemasukan;
    private final StringProperty pengeluaran;
    
    public data(String tanggal, String kategori, String pemasukan, String pengeluaran){
        this.tanggal = new SimpleStringProperty(tanggal);
        this.kategori = new SimpleStringProperty(kategori);
        this.pemasukan = new SimpleStringProperty(pemasukan);
        this.pengeluaran = new SimpleStringProperty(pengeluaran);
        }
    public String getTanggal(){
        return tanggal.get();
    }
    
    public String getKategori(){
        return kategori.get();
    }
    
    public String getPemasukan(){
        return pemasukan.get();
    }
    
    public String getPengeluaran(){
        return pengeluaran.get();
    }
    
    public void setTanggal(String value){
        tanggal.set(value);
    }
    
    public void setKategori(String value){
        kategori.set(value);
    }
    
    public void setPemasukan(String value){
        pemasukan.set(value);
    }
    
    public void setPengeluaran(String value){
        pengeluaran.set(value);
    }
    
    public StringProperty tanggalProperty(){
        return tanggal;
    }
    
    public StringProperty kategoriProperty(){
        return kategori;
    }
    public StringProperty pemasukanProperty(){
        return pemasukan;
    }
    
    public StringProperty pengeluaranProperty(){
        return pengeluaran;
    }
    
    
 
}
