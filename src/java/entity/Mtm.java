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
public class Mtm {
    private int manyid;
    private Musteri musteriID;
    private Mama mamaID;

    public Mtm(int manyid, Musteri musteriID, Mama mamaID) {
        this.manyid = manyid;
        this.musteriID = musteriID;
        this.mamaID = mamaID;
    }
    

    

    public Mtm() {
    }

    public int getManyid() {
        return manyid;
    }

    public void setManyid(int manyid) {
        this.manyid = manyid;
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
