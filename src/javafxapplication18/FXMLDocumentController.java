/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import java.awt.Label;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXButton signup;

    @FXML
    private JFXTextField username;
    
     @FXML
    private AnchorPane background;

    @FXML
    private JFXPasswordField password;
    private Label inPass;
    private Label inUser;
    public String Username, Password;
 @FXML
    private Button btnCetak2;
    @FXML
    private JFXButton login;
    public String user="user";
    public String pass="123";
  @FXML
    private CheckBox remember;
    @FXML
    void btnLogIn(ActionEvent event) {
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;                                      
                
        try {
            sql = "SELECT * FROM user WHERE username='"+username.getText()+"' AND password='"+password.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password"))){
               String nama = rs.getString("nama_user");
            // Hide this current window (if this is what you want)
            JOptionPane.showMessageDialog(null, "Login Succes");
          
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument2.fxml"));
             Scene scene = new Scene(fxmlLoader.load());
             FXMLDocument2Controller fxml2Controller = fxmlLoader.getController();
           fxml2Controller.setnama(nama);
           
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Ice Cream");
            stage.show();
                }
              
            }else{
                    
                if( username.getText().equals("") && password.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Masukkan Data!");}
                else if( username.getText().equals("")){
        JOptionPane.showMessageDialog(null, "Username salah");}
                else if(password.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Password salah");
                }}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
        

    @FXML
    void btnSignUp(ActionEvent event) {
try{
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLSignUp.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Ris'Cream");
                stage.show();
            } catch(IOException e){
                System.out.println("Failed "+e);
            }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    void exit(ActionEvent event) {
 Platform.exit();
    }
}
