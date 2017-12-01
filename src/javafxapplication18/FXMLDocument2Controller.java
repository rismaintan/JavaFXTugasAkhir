/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLDocument2Controller implements Initializable {
String jeneng;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private ImageView gambar1;
    @FXML
    private ImageView gambar2;
        @FXML
    private Button buttonmenu;
         @FXML
    private Button btnCetak2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void IceCream(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();

            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument3.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
              FXMLDocument3Controller fxml2Controller = fxmlLoader.getController();
          
            fxml2Controller.setjng(jeneng);
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
 @FXML
    void kembalikemenu(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();

            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setTitle("Ris'CREAM");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    }
    public void setnama(String nama){
    jeneng = nama;
    }
    @FXML
    private void Minuman(ActionEvent event) {
        try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
String tampil="",menu="";
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLMakanan.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
             FXMLMakananController fxml2Controller = fxmlLoader.getController();
          
           // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
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
