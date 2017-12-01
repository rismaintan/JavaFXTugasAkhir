/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.sql.Connection;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLSignUpController implements Initializable {

    @FXML
    private JFXTextField fullname;
    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private Button singup;
    @FXML
    private JFXButton login;
        @FXML
    private JFXButton buttonmenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
@FXML
    void btnLogIn(ActionEvent event) {
try{
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Ris'Cream");
                stage.show();
            } catch(IOException e){
                System.out.println("Failed "+e);
            }
    }
    @FXML
    private void SignUp(ActionEvent event) {
        
       try{
           
           if (fullname.getText().equals("")&& username.getText().equals("") && password.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Lengkapi Data!");
           }
           else if (fullname.getText().equals("") && username.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Nama Lengkap dan Username kosong!");
           }
            
            else if (username.getText().equals("") && password.getText().equals("") ){
            JOptionPane.showMessageDialog(null, "Username dan Password kosong!");
           }
             else if (password.getText().equals("") &&fullname.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Password dan Nama Lengkap kosong!");
           }
             else if (password.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Password  kosong!");
           }
             else if (fullname.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Lengkap kosong!");
           }
             else if (username.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Username kosong!");
           }
           else{
            String sql = "INSERT INTO user (nama_user,username,password) VALUES ('"+fullname.getText()+"',"
                    + "'"+username.getText()+"','"+password.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sign Up Succes");
            try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Sign Up");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e.getMessage());
        }}
        } catch (Exception e) {
 System.out.println("Failed to create new Window." + e.getMessage());
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
            stage.setScene(scene);
            stage.setTitle("Ris'CREAM");
            stage.show();

        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
    
    }
}
