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
public class Cins {
    private int cinsID;
    private String cinsad;

    public Cins(int cinsID, String cinsad) {
        this.cinsID = cinsID;
        this.cinsad = cinsad;
    }

    public Cins() {
    }

    public int getCinsID() {
        return cinsID;
    }

    public void setCinsID(int cinsID) {
        this.cinsID = cinsID;
    }

    public String getCinsad() {
        return cinsad;
    }

    public void setCinsad(String cinsad) {
        this.cinsad = cinsad;
    }
    
    
    
}
