/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.CinsDAO;
import entity.Cins;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Acer
 */
@FacesConverter (value="cinsConverter")
public class CinsConverter implements Converter{
    private CinsDAO cinsDAO;

    public CinsDAO getCinsDAO() {
        if(this.cinsDAO==null){
            this.cinsDAO=new CinsDAO();
        }
        return cinsDAO;
    }

    public void setCinsDAO(CinsDAO cinsDAO) {
        this.cinsDAO = cinsDAO;
    }
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return this.getCinsDAO().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Cins l=(Cins)t;
        return String.valueOf(l.getCinsID());
    }
    
}
