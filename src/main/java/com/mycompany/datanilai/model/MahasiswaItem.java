package com.mycompany.datanilai.model;

public class MahasiswaItem {
    private String nim;
    private String nama;
    
    public MahasiswaItem(String nim, String nama){
        this.nim = nim;
        this.nama = nama;
    }
    
    public String getNim(){
        return nim;
    }
    
    public String getNama(){
        return nama;
    }
    
    @Override
    public String toString(){
        return nama;
    }
}
