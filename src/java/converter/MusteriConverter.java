/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.MusteriDAO;
import entity.Musteri;
import java.util.Objects;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter (value="musteriConverter")
public class MusteriConverter implements Converter{

    
        private MusteriDAO musteriDAO;

    public MusteriDAO getMusteriDAO() {
        if(this.musteriDAO==null){
            this.musteriDAO=new MusteriDAO();
        }
        return musteriDAO;
    }

    public void setMusteriDAO(MusteriDAO musteriDAO) {
        this.musteriDAO = musteriDAO;
    }

    
        
        
        
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
       return this.getMusteriDAO().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
       Musteri l=(Musteri)t;
        return String.valueOf(l.getMusteriID());
    }
    
}
