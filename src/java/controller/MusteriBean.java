/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MusteriDAO;

import entity.Musteri;
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
public class MusteriBean implements Serializable{
    
    private MusteriDAO dao;
    private Musteri entity;
    private List<Musteri> musterilist;

   /* public List<Musteri> getMusterilist() {
        this.musterilist=this.getDao().findAll();
        return musterilist;
    }

    public void setMusterilist(List<Musteri> musterilist) {
        this.musterilist = musterilist;
    }*/
    
   
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
        this.entity=new Musteri();
        return "/musteri/list";
    }
   /*public Musteri getById(int id){
        return this.getDao().getById(id);
        
    }*/
    
    
    public List<Musteri> getRead() {
        return this.getDao().read(page,pageSize);

    }

    public String updateForm(Musteri c) {
        this.entity = c;
        return "/musteri/update";
    }

    public String update() {
        this.getDao().update(entity);
        this.entity=new Musteri();
        return "/musteri/list";
    }

    public void delete(Musteri c) {
        this.getDao().delete(c);
         
       
       
    }

    public MusteriBean() {
       
        
    }

    public MusteriDAO getDao() {
        if (this.dao == null) {
            this.dao = new MusteriDAO();
        }

        return dao;
    }

    public void setDao(MusteriDAO dao) {
        this.dao = dao;
    }

    public Musteri getEntity() {
        if (this.entity == null) {
            this.entity = new Musteri();
        }
        return entity;
    }

    public void setEntity(Musteri entity) {
        this.entity = entity;
    }

    
}
