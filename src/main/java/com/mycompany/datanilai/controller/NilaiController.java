package com.mycompany.datanilai.controller;

import com.mycompany.datanilai.config.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mycompany.datanilai.model.MahasiswaItem;
import javax.swing.JComboBox;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

import com.mycompany.datanilai.model.MataKuliahItem;

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
    public void loadMahasiswa(JComboBox cmbMahasiswa){
        try {
            Connection conn = koneksi.getKoneksi();
            String sql = 
                    "SELECT nim, nama "
                    +"FROM t_mahasiswa "
                    +"ORDER BY nama";
            
            Statement st = 
                    conn.createStatement();
            
            ResultSet rs = 
                    st.executeQuery(sql);
            
            cmbMahasiswa.removeAllItems();
            
            while (rs.next()) {
                cmbMahasiswa.addItem(
                        new MahasiswaItem(
                            rs.getString("nim"),
                            rs.getString("nama")
                        )
                );
            }
                    
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }   
    }
    public String hitungIndeks(double nilai){
        if (nilai >= 80){
            return "A";
        } else if(nilai >= 70){
            return "B";
        } else if(nilai >=60){
            return "C";
        } else if (nilai >= 50){
            return "D";
        } else {
            return "E";
        }
    }
    
    public String hitungKeterangan (double nilai){
        if (nilai >= 60){
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
    
    public void loadMataKuliah(JComboBox cmbMataKuliah){
        try {
            Connection conn = koneksi.getKoneksi();
            
            String sql = "SELECT kd_mk, nama_mk FROM t_mata_kuliah ORDER BY nama_mk";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            cmbMataKuliah.removeAllItems();
            
            while (rs.next()) {
                cmbMataKuliah.addItem(
                        new MataKuliahItem(rs.getString("kd_mk"), rs.getString("nama_mk"))
                    );
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Memuat mata kuliah: "+e.getMessage());
        }
    }
    
    public void simpanData(String nim, double nilai, String kdMk){
        try {
            String index = hitungIndeks(nilai);
            String ket = hitungKeterangan(nilai);
            Connection conn = koneksi.getKoneksi();
            
            String sql = 
                    "INSERT INTO t_nilai"
                    +"(nim,kd_mk,nilai,`index`,ket)"
                    +"VALUES(?,?,?,?,?)";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,nim);
            ps.setString(2,kdMk);
            ps.setDouble(3,nilai);
            ps.setString(4,index);
            ps.setString(5,ket);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data"+ e.getMessage());
        }
    }
    
    public void ubahData(String nim, double nilai, int idNilai, String kdMk){
        try {
            String index = hitungIndeks(nilai);
            String ket = hitungKeterangan(nilai);
            Connection conn = koneksi.getKoneksi();
            
            String sql = "UPDATE t_nilai SET nim = ?, kd_mk = ?, nilai = ?, `index` = ?, ket = ? WHERE kd_nilai = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1,nim);
            ps.setString(2,kdMk);
            ps.setDouble(3,nilai);
            ps.setString(4,index);
            ps.setString(5,ket);
            ps.setInt(6,idNilai);
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Mengubah Data: "+e.getMessage());
        }
    }
    
    public void hapusData(int idNilai){
        try {
            Connection conn = koneksi.getKoneksi();
            
            String sql = "DELETE FROM t_nilai WHERE kd_nilai = ?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, idNilai);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0){
                javax.swing.JOptionPane.showMessageDialog(null, "Data Berhasil dihapus");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Gagal Menghapus Data: "+e.getMessage());
        }
    }
    
    public void setMasukanCombo(JComboBox cmbMahasiswa, JComboBox cmbMataKuliah, String nim, String kdMk){
        try {
        // Logika memilih Mahasiswa
        for (int i = 0; i < cmbMahasiswa.getItemCount(); i++) {
            // Kita cek dulu, kalau itemnya berupa String bawaan NetBeans (Item 1, dst), kita lewati saja
            if (cmbMahasiswa.getItemAt(i) instanceof String) {
                continue; 
            }
            
            // Jika bukan String, berarti ini pasti objek MahasiswaItem yang aman untuk di-casting
            MahasiswaItem item = (MahasiswaItem) cmbMahasiswa.getItemAt(i);
            if (item.getNim().equals(nim)) {
                cmbMahasiswa.setSelectedIndex(i);
                break;
            }
        }
        
        // Logika memilih Mata Kuliah
        for (int i = 0; i < cmbMataKuliah.getItemCount(); i++) {
            // Kita cek juga untuk mata kuliah, kalau teks bawaan NetBeans, lewati
            if (cmbMataKuliah.getItemAt(i) instanceof String) {
                continue;
            }
            
            MataKuliahItem item = (MataKuliahItem) cmbMataKuliah.getItemAt(i);
            if (item.getKdMk().equals(kdMk)) {
                cmbMataKuliah.setSelectedIndex(i);
                break;
            }
        }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal memuat data lama: " + e.getMessage());
        }
    }
}
