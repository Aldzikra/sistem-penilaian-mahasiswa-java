package com.mycompany.datanilai.model;

public class MataKuliahItem {
    private String kdMk;
    private String namaMk;
    
    public MataKuliahItem(String kdMk, String namaMk){
        this.kdMk = kdMk;
        this.namaMk = namaMk;
    }
    
    public String getKdMk(){
        return kdMk;
    } 
    
    public String getNamaMk(){
        return namaMk;
    }
    
    @Override
    public String toString(){
        return namaMk;
    }
}
