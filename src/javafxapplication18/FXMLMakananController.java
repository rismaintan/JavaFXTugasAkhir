/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLMakananController implements Initializable {
FXMLDocumentController tes = new FXMLDocumentController();
    @FXML
    private JFXButton btnCetak;
    @FXML
    private JFXCheckBox mak1;
    @FXML
    private JFXCheckBox mak2;
    @FXML
    private JFXCheckBox mak3;
    @FXML
    private JFXCheckBox mak6;
    @FXML
    private JFXTextArea hasilPesanan1;
    @FXML
    private JFXCheckBox mak5;
    @FXML
    private JFXCheckBox mak4;
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
    private JFXButton btnCetak2;
    @FXML
    private JFXTextField jumlah4;
    @FXML
    private JFXButton btnCetak1;
      @FXML
    private JFXTextField nomeja;
      @FXML
    private JFXTextField nama;
    @FXML
    private Button sebelumnya;
    @FXML
    private JFXButton totalkeseluruhan;
    @FXML
    private Label total1;
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
    private void gifcardNoodles(ActionEvent event) {
    }

    @FXML
    private void gifcardUdang(ActionEvent event) {
    }

    @FXML
    private void fried(ActionEvent event) {
    }

    @FXML
    private void salad(ActionEvent event) {
    }

    @FXML
    private void japanesePan(ActionEvent event) {
    }

    @FXML
    private void heroTeriyaki(ActionEvent event) {
    }

    @FXML
    private void Hitung(ActionEvent event) {
         
    }
     
  public void setjng(String nama){
    nm = nama;
    }
    
    @FXML
    void CetakPemesan(ActionEvent event) {
        if(mak1.isSelected()){     
            harga = 15000;
            menu += mak1.getText()+", ";
            jumlahice=Integer.parseInt(jumlah1.getText());
            hargatotal1=harga*jumlahice;
            System.out.println(hargatotal1);
            
        }
        if(mak2.isSelected()){     
            harga = 20000;
            menu += mak2.getText()+", ";
            jumlahice=Integer.parseInt(jumlah2.getText());
            hargatotal2=harga*jumlahice;
            System.out.println(hargatotal2);
        }
        
        if(mak3.isSelected()){     
            harga = 10000;
            menu += mak3.getText()+", ";
            jumlahice=Integer.parseInt(jumlah3.getText());
            hargatotal3=harga*jumlahice;
            System.out.println(hargatotal3);
        }
        if(mak4.isSelected()){     
            harga = 12000;
            menu += mak4.getText()+", ";
            jumlahice=Integer.parseInt(jumlah4.getText());
            hargatotal4=harga*jumlahice;
            System.out.println(hargatotal4);
        }
        
        if(mak5.isSelected()){     
            harga = 15000;
            menu += mak5.getText()+", ";
            jumlahice=Integer.parseInt(jumlah5.getText());
            hargatotal5=harga*jumlahice;
            System.out.println(hargatotal5);
        }
        
        if(mak6.isSelected()){     
            harga = 20000;
            menu += mak6.getText()+", ";
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
        if(nomeja.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Data Tidak lengkap!");}
         else if( nama.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Isi namanya ya!");
        }
         else{
           ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLTampilanHasilIce.fxml"));
            Parent root = (Parent) loader.load();
           
            FXMLTampilanHasilIceController fxml2Controller = loader.getController();
          
            fxml2Controller.myFunction(nm,tampilTotalBayar, menu, nomeja.getText(), nama.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
        }
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
  }
  
    @FXML
    void lanjut(ActionEvent event) {
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
            stage.setTitle("riz");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }   
    }
    @FXML
    void exit(ActionEvent event) {
 Platform.exit();
    }
    @FXML
    void Nmena(ActionEvent event) {
        nomeja.getText();
    }

}
