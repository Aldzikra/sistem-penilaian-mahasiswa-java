package com.mycompany.datanilai.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    public static Connection konek;
    
    public static Connection getKoneksi(){
        if (konek == null){
            try {
                // Alamat Database
                String url = "jdbc:mysql://localhost:3306/java_akdmk";
                String usr = "root";
                String password = "";
                
                // Mendaftarkan driver MySQL versi 5
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                
                konek = DriverManager.getConnection(url, usr, password);
                System.out.println("Koneksi Database Berhasil");
                
            } catch(SQLException e) {
                System.out.println("Koneksi Database Gagal!"+e.getMessage());
            }
        }
        return konek;
    }
}
