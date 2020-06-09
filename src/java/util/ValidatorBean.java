/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Acer
 */
@FacesValidator(value = "customvalidator")
public class ValidatorBean implements Validator {

    Pattern pattern;
    Matcher matcher;

    public ValidatorBean() {

        pattern = Pattern.compile("^[A-Za-z0-9-+]+(\\.[A-Za-z0-9+-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$");

    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Geçersiz Bir Mail Girdiniz. E-bültene Abone Olmak için Lütfen Geçerli Bir Mail Adresi Giriniz.", "E-posta uyarı");

            throw new ValidatorException(message);

        }
    }

}
