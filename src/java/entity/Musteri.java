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
public class Musteri {
    private int musteriID;
    private String musteriad;
    private String musterisoyad;
    private Cins mustericinsID;

    public Musteri() {
    }

    public Musteri(int musteriID, String musteriad, String musterisoyad, Cins mustericinsID) {
        this.musteriID = musteriID;
        this.musteriad = musteriad;
        this.musterisoyad = musterisoyad;
        this.mustericinsID = mustericinsID;
    }

    

    
    public int getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(int musteriID) {
        this.musteriID = musteriID;
    }

    public String getMusteriad() {
        return musteriad;
    }

    public void setMusteriad(String musteriad) {
        this.musteriad = musteriad;
    }

    public String getMusterisoyad() {
        return musterisoyad;
    }

    public void setMusterisoyad(String musterisoyad) {
        this.musterisoyad = musterisoyad;
    }

    public Cins getMustericinsID() {
        return mustericinsID;
    }

    public void setMustericinsID(Cins mustericinsID) {
        this.mustericinsID = mustericinsID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.musteriID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musteri other = (Musteri) obj;
        if (this.musteriID != other.musteriID) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
