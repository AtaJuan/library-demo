 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.com.soagen.utility;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import tr.com.soagen.dao.AuthorDao;
import tr.com.soagen.presentation.model.Author;

/**
 *
 * @author atacankullabci
 */
@Controller("authorConverter")
@Scope("request")
public class AuthorConverter implements Converter {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
        if (submittedValue == null || submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                Long id = Long.parseLong(submittedValue);

                return authorDao.getAuthorById(id);

            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion error", ""));
            }
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value == null) {
            return "";
        } else {
            return String.valueOf(((Author) value).getId());
        }
    }

}
