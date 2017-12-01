/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication18;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author rismaintanw
 */
public class Data {
    private SimpleStringProperty nomeja, Nama, total;

    public Data(String string, String cheetos, String makanan, String plastik, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void myFunction(String Username, String ttl, String menu, String no, String nam) {
        this.nomeja = new SimpleStringProperty(no);
        this.Nama = new SimpleStringProperty(nam);
         this.total = new SimpleStringProperty(ttl);
       }
    public String getNama() {
        return Nama.get();
    }

    public void setNama(String Nama) {
        this.Nama = new SimpleStringProperty(Nama);
    }
public String getmeja() {
        return nomeja.get();
    }

    public void settota(String Nama) {
        this.total = new SimpleStringProperty(Nama);
    }

}
