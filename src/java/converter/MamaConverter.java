/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;


import dao.CinsDAO;
import dao.MamaDAO;
import entity.Cins;
import entity.Mama;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Acer
 */
@FacesConverter (value="mamaConverter")
public class MamaConverter implements Converter{
    
     private MamaDAO mamaDAO;

    public MamaDAO getMamaDAO() {
        if(this.mamaDAO==null){
            this.mamaDAO=new MamaDAO();
        }
        return mamaDAO;
    }

    public void setMamaDAO(MamaDAO mamaDAO) {
        this.mamaDAO = mamaDAO;
    }
     

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getMamaDAO().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
       Mama m=(Mama)t;
        return String.valueOf(m.getMamaID());
    }
    
}
