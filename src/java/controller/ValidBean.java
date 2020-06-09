/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Acer
 */
@ManagedBean
@RequestScoped
public class ValidBean implements Serializable{
    private String email;
    private String output;
    
    public void correctvalidator(){
        output="Sayın "+email+" Mail Adresli Kullanıcımız E-bültenimize Abone Olduğunuz için Teşekkür Ederiz... <Petshop Admini>";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
}
