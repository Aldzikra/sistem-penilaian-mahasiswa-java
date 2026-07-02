package com.mycompany.datanilai;
import com.mycompany.datanilai.view.MenuUtama;
import com.mycompany.datanilai.config.koneksi;

public class Datanilai {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            MenuUtama menu = new MenuUtama();
            
            // logging database
            koneksi.getKoneksi();
            
            // nampilin menu utama
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        });
        
    }
}
 