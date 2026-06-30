package com.mycompany.datanilai.controller;

import com.mycompany.datanilai.config.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NilaiController {
    public void tampilData(JTable table){
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("NIM");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("Kode Nilai");
        model.addColumn("Kode MK");
        model.addColumn("Nilai");
        model.addColumn("Indeks");
        model.addColumn("Keterangan");
        
        try {
            Connection conn = koneksi.getKoneksi();
            
            String sql =
                    "SELECT "
                    + "m.nim, "
                    + "m.nama, "
                    + "n.kd_nilai, "
                    + "n.kd_mk, "
                    + "n.nilai, "
                    + "n.`index`, " 
                    + "n.ket "
                    + "FROM t_mahasiswa m "
                    + "INNER JOIN t_nilai n "
                    + "ON m.nim = n.nim";
            
           Statement st = conn.createStatement();
           
           ResultSet rs = st.executeQuery(sql);
           
           while (rs.next()) {
               model.addRow(new Object[]{
                   rs.getString("nim"),
                   rs.getString("nama"),
                   rs.getInt("kd_nilai"),
                   rs.getString("kd_mk"),
                   rs.getDouble("nilai"),
                   rs.getString("index"),
                   rs.getString("ket")
               });
           }
           
           table.setModel(model);
        } catch (SQLException e){
            System.out.println("Gagal Menampilkan Data : "+e.getMessage());
        }
    }
}
