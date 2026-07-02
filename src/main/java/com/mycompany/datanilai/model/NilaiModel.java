package com.mycompany.datanilai.model;

public class NilaiModel {
    private String nim;
    private String nama;
    private int kdNilai;
    private String kdMk;
    private double nilai;
    private String index;
    private String keterangan;
    
    public NilaiModel(){   
    }
    
    public String getNim(){
        return nim;
    }
    
    public void setNim(String nim){
        this.nim = nim;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public int getKdNilai(){
        return kdNilai;
    }
    
    public void setKdNilai(int kdNilai){
        this.kdNilai = kdNilai;
    }
    
    public String getKdMk(){
        return kdMk;
    }
    
    public void setKdMk(String kdMk){
        this.kdMk = kdMk;
    }
    
    public double getNilai(){
        return nilai;
    }
    
    public void setNilai(double nilai){
        this.nilai = nilai;
    }
    
    public String getIndex(){
        return index;
    }
    public void setIndex(String index){
        this.index = index;
    }
    
    public String getKeterangan(){
        return keterangan;
    }
    
    public void setKeterangan(String keterangan){
        this.keterangan = keterangan;
    }
}
