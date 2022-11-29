package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("Yvalid")
public class YValidator implements Validator {

    Message message = new Message();

    private Boolean validateY(String y){
        String regex = "^-?[0-9]+([.,]?[0-9]+)?$";
        return y.matches(regex)&&Float.parseFloat(y)>=-5 && Float.parseFloat(y)<=5;
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            if (!validateY(o.toString())) {
                throw new ValidatorException(message.createMessage("Некорректное значение Y!"));
            }
        }
        catch (NullPointerException e){
            throw new ValidatorException(message.createMessage("Введите значение Y!"));
        }
    }
}
