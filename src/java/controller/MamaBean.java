/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MamaDAO;
import entity.Mama;
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
public class MamaBean implements Serializable{
     private MamaDAO dao;
    private Mama entity;
    
   private int page=1;
    private int pageSize=10;
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
        this.entity=new Mama();
        return "/mama/list";
    }
    public Mama getById(int id){
        return this.getDao().getById(id);
        
    }
    
    
    public List<Mama> getRead() {
        return this.getDao().read(page,pageSize);

    }

    public String updateForm(Mama c) {
        this.entity = c;
        return "/mama/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity=new Mama();
        return "/mama/list";
    }

    public void delete(Mama c) {
        this.getDao().delete(c);
    }

    public MamaBean() {
    }

    public MamaDAO getDao() {
        if (this.dao == null) {
            this.dao = new MamaDAO();
        }

        return dao;
    }

    public void setDao(MamaDAO dao) {
        this.dao = dao;
    }

    public Mama getEntity() {
        if (this.entity == null) {
            this.entity = new Mama();
        }
        return entity;
    }

    public void setEntity(Mama entity) {
        this.entity = entity;
    }

    
}
