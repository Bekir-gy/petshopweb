/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CinsDAO;
import entity.Cins;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Acer
 */
@Named
@SessionScoped
public class CinsBean implements Serializable{
    private CinsDAO dao;
    private Cins entity;
    
   

    public String create() {
        this.getDao().create(entity);
        this.entity=new Cins();
        return "/cins/list";
    }
    public Cins getById(int id){
        return this.getDao().getById(id);
        
    }
    
    
    public List<Cins> getRead() {
        return this.getDao().read();

    }

    public String updateForm(Cins c) {
        this.entity = c;
        return "/cins/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity=new Cins();
        return "/cins/list";
    }

    public void delete(Cins c) {
        this.getDao().delete(c);
    }

    public CinsBean() {
    }

    public CinsDAO getDao() {
        if (this.dao == null) {
            this.dao = new CinsDAO();
        }

        return dao;
    }

    public void setDao(CinsDAO dao) {
        this.dao = dao;
    }

    public Cins getEntity() {
        if (this.entity == null) {
            this.entity = new Cins();
        }
        return entity;
    }

    public void setEntity(Cins entity) {
        this.entity = entity;
    }

    
    
    
    
}
