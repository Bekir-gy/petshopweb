/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import entity.User;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Acer
 */
@SessionScoped
@ManagedBean
public class LoginController implements Serializable{
    private String username;
    private String password;
    private UserDataManager dataManager;
    private User sessionUser;
    
    @PostConstruct
    public void init(){
        if(dataManager==null){
            dataManager=new UserDataManager();
        }
        
    }
    public String login(){
        sessionUser=dataManager.findUser(username, password);
        if(sessionUser!=null){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
            return "template/admin.xhtml";
        }else{
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage("hatalı giriş yaptınız"));
        }
        return "index.xhtml";
    }
        public void logout(){
             FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("username");
             FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }
     
    
    
}
