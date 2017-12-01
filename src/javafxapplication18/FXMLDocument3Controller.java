/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLDocument3Controller implements Initializable {
FXMLDocumentController tes = new FXMLDocumentController();
    @FXML
    private JFXCheckBox ice1;
    @FXML
    private JFXCheckBox ice2;
    @FXML
    private JFXCheckBox ice3;
    @FXML
    private JFXCheckBox ice5;
    @FXML
    private JFXCheckBox ice6;
    @FXML
    private JFXCheckBox ice4;
    @FXML
    private JFXTextField jumlah1;
    @FXML
    private JFXTextField jumlah2;
    @FXML
    private JFXTextField jumlah3;
    @FXML
    private JFXTextField jumlah6;
    @FXML
    private JFXTextField jumlah5;
        @FXML
    private JFXTextField nama;

    @FXML
    private JFXTextField jumlah4;
    @FXML
    private JFXButton btnCetak1;
    @FXML
    private JFXButton btnCetak2;
    @FXML
    private Label total1;
    @FXML
    private JFXButton btnCetak;
    @FXML
    private JFXTextArea hasilPesanan1;
    @FXML
    private JFXTextField nomeja;
    @FXML
    private Button selanjutnya;
    int harga,jumlahice,totalbayar, hargatotal1, hargatotal2, hargatotal3, hargatotal4, hargatotal5, hargatotal6;
    String menu ="",nm;
    String tampilTotalBayar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void noodleIce(ActionEvent event) {
    }

    @FXML
    private void honeyIce(ActionEvent event) {
    }

    @FXML
    private void toppingCherry(ActionEvent event) {
    }

    @FXML
    private void strawberryIce(ActionEvent event) {
    }

    @FXML
    private void fulloIce(ActionEvent event) {
    }

    @FXML
    private void rainbowIce(ActionEvent event) {
    }
    

    @FXML
    private void Hitung(ActionEvent event) {
          

    }
    public void setjng(String nama){
    nm = nama;
    }
    @FXML
    private void CetakPemesan(ActionEvent event) {
         if(ice1.isSelected()){     
            harga = 10000;
            menu += ice1.getText()+", ";
            jumlahice=Integer.parseInt(jumlah1.getText());
            hargatotal1=harga*jumlahice;
            System.out.println(hargatotal1);  
        }
        if(ice2.isSelected()){     
            harga = 15000;
            menu += ice2.getText()+", ";
            jumlahice=Integer.parseInt(jumlah2.getText());
            hargatotal2=harga*jumlahice;
            System.out.println(hargatotal2);
        }
        if(ice3.isSelected()){     
            harga = 20000;
            menu += ice3.getText()+", ";
            jumlahice=Integer.parseInt(jumlah3.getText());
            hargatotal3=harga*jumlahice;
            System.out.println(hargatotal3);
        }
        if(ice4.isSelected()){     
            harga = 15000;
            menu += ice4.getText()+", ";
            jumlahice=Integer.parseInt(jumlah4.getText());
            hargatotal4=harga*jumlahice;
            System.out.println(hargatotal4);
        }
        
        if(ice5.isSelected()){     
            harga = 15000;
            menu += ice5.getText()+", ";
            jumlahice=Integer.parseInt(jumlah5.getText());
            hargatotal5=harga*jumlahice;
            System.out.println(hargatotal5);
        }
        if(ice6.isSelected()){     
            harga = 15000;
            menu += ice6.getText()+", ";
            jumlahice=Integer.parseInt(jumlah6.getText());
            hargatotal6=harga*jumlahice;
            System.out.println(hargatotal6);
        }
        totalbayar = hargatotal1+hargatotal2+hargatotal3+hargatotal4+hargatotal5+hargatotal6;
        tampilTotalBayar=String.valueOf(totalbayar);
      
    try {
        Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        if(nomeja.getText().equals("") && nama.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Masukkan Nomer Meja dan Nama");}
        else if( nomeja.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Nomer meja belum terisi !");
        }
        else if( nama.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Nama belum terisi !");
        }
        else{
           ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLTampilanHasilIce.fxml"));
            Parent root = (Parent) loader.load();
           
            FXMLTampilanHasilIceController fxml2Controller = loader.getController();
            
            fxml2Controller.myFunction(nm,tampilTotalBayar, menu, nomeja.getText(), nama.getText());
            Stage stage = new Stage();
            
            stage.setTitle("Ris'CREAM");
            stage.setScene(new Scene(root));
            stage.show();   
        }
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }

    @FXML
    private void lanjut(ActionEvent event) {
     try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument2.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Minuman");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }   
    }
     @FXML
    void exit(ActionEvent event) {
        Platform.exit();
    }

    
}
