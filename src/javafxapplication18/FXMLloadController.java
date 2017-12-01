/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author rismaintanw
 */
public class FXMLloadController implements Initializable {
ObservableList<String> list1 = FXCollections.observableArrayList("Makanan","Minuman","Snack");
    ObservableList<String> list2 = FXCollections.observableArrayList("Kardus","Plastik","Box");

    @FXML
    private TableView<?> tableuser;
    @FXML
    private TableColumn<Data, String> nomermejaa;
    @FXML
    private TableColumn<Data, String> namapell;
    @FXML
    private TableColumn<Data, String> totall;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        nomermejaa.setCellValueFactory(new PropertyValueFactory<Data, String>("Kode"));
         namapell.setCellValueFactory(new PropertyValueFactory<Data, String>("Nama"));
         totall.setCellValueFactory(new PropertyValueFactory<Data, String>("Kategori"));
        
         tableuser.setEditable(true);
         nomermejaa.setCellFactory(TextFieldTableCell.forTableColumn());
         namapell.setCellFactory(TextFieldTableCell.forTableColumn());
         totall.setCellFactory(TextFieldTableCell.forTableColumn());
         
               tableuser.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
   
    }    
    
}
