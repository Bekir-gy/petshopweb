/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Acer
 */
public class Mama {
    
    private int mamaID;
    private String mamaad;
   

    public Mama() {
    }

   
    public Mama(int mamaID, String mamaad) {
        this.mamaID = mamaID;
        this.mamaad = mamaad;
    }

    
    

    public int getMamaID() {
        return mamaID;
    }

    public void setMamaID(int mamaID) {
        this.mamaID = mamaID;
    }

    public String getMamaad() {
        return mamaad;
    }

    public void setMamaad(String mamaad) {
        this.mamaad = mamaad;
    }

   
    
    
    
}
