package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("Rvalid")
public class RValidator implements Validator {

    Message message = new Message();

    private Boolean validateR(String r){
        String regex = "^-?[0-9]+([.,]?[0-9]+)?$";
        return r.matches(regex)&&Float.parseFloat(r)>=1 && Float.parseFloat(r)<=4;
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            if (!validateR(o.toString())) {
                throw new ValidatorException(message.createMessage("Некорректное значение R!"));
            }
        }
        catch (NullPointerException e){
            throw new ValidatorException(message.createMessage("Введите значение R!"));
        }
    }
}
