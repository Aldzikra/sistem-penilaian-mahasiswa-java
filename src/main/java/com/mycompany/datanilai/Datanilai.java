package com.mycompany.datanilai;
import com.mycompany.datanilai.view.FormNilai;

public class Datanilai {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            FormNilai form = new FormNilai();
            form.setLocationRelativeTo(null);
            form.setVisible(true);
        });
        
    }
}
 