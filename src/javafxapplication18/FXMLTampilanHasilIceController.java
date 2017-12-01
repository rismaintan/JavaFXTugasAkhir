/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLTampilanHasilIceController implements Initializable {
FXMLDocumentController tes = new FXMLDocumentController();
String nm;    
int totalkeseluruhan;
@FXML
    private Label hasilPesanan1;
      @FXML
    private JFXButton pesan;
      
    @FXML
    private Label nomeja;
        @FXML
    private Label nama;

    @FXML
    private JFXTextField bayar;
      @FXML
    private Label total;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void setjeneng(String jen){
    nm = jen;
    }
    
    public void myFunction( String Username, String ttl, String menu, String no, String nam){
        nomeja.setText(no);
        nama.setText(nam);
        total.setText(ttl);
        hasilPesanan1.setText(menu);
    nomeja.getText();
    nama.getText();
    total.getText();
    }
    @FXML
    void pesanlagi(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();

            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument2.fxml"));
            JOptionPane.showMessageDialog(null, "Terimakasih");
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ris'CREAM");
            stage.show();

        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
}
