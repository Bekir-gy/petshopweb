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
public class MTM {
    
    private Musteri musteriID;
    private Mama mamaID;

    public MTM(Musteri musteriID, Mama mamaID) {
        this.musteriID = musteriID;
        this.mamaID = mamaID;
    }

    public MTM() {
    }

    
    

    public Musteri getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(Musteri musteriID) {
        this.musteriID = musteriID;
    }

    public Mama getMamaID() {
        return mamaID;
    }

    public void setMamaID(Mama mamaID) {
        this.mamaID = mamaID;
    }
    
    
}
