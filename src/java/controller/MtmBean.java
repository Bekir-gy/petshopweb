/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MtmDAO;
import entity.Mtm;
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
public class MtmBean implements Serializable{
    private MtmDAO dao;
    private Mtm entity;
    
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
    
    

    public MtmDAO getDao() {
        if(this.dao==null){
            this.dao= new MtmDAO();
        }
        return dao;
    }

    public void setDao(MtmDAO dao) {
        this.dao = dao;
    }

    public Mtm getEntity() {
        if(this.entity==null){
            this.entity=new Mtm();
        }
        return entity;
    }

    public void setEntity(Mtm entity) {
        this.entity = entity;
    }
    
    
     public String create() {
        /*Language l=languageBean.getDao().getById(selectedLanguage);
        entity.setLanguage(l);*/
        this.getDao().create(entity);
        this.entity=new Mtm();
        return "/mtm/list";
    }
     
     
     public List<Mtm> getRead() {
        return this.getDao().read(page,pageSize);

    }
     
      public String updateForm(Mtm c) {
        this.entity = c;
       /* this.selectedLanguage=c.getLanguage().getLanguageId();*/
        return "/mtm/update";
    }
      
       public String update() {
        /*Language l=languageBean.getDao().getById(selectedLanguage);
        entity.setLanguage(l);*/
        this.getDao().update(entity);
        this.entity=new Mtm();
        return "/mtm/list";
    }
       
       public void delete(Mtm c) {
        this.getDao().delete(c);
    }

    public MtmBean() {
    }
       
       
}
