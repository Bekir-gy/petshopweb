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
    
     private int page=1;
    private int pageSize=5;
    private int pageCount;

    public void next(){
        if(this.page == this.getPageCount() ){
            this.page=1;
        }
        else{
            this.page++;
        }
    }
    public void previous(){
        if(this.page==1){
            this.page=this.getPageCount();
        }else{
            this.page--;
        }
        
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount=(int)Math.ceil(this.getDao().count()/(double)pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
   

    public String create() {
        this.getDao().create(entity);
        this.entity=new Cins();
        return "/cins/list";
    }
    public Cins getById(int id){
        return this.getDao().getById(id);
        
    }
    
    
    public List<Cins> getRead() {
        return this.getDao().read(page,pageSize);

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
