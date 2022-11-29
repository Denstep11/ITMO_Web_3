package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("Xvalid")
public class XValidator implements Validator {

    Message message = new Message();

    private Boolean validateX(String x){
        for(float i=-3; i<=5;i++){
            if(Float.parseFloat(x)==i){
                return true;
            }
        }
        return false;
    }

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            if (!validateX(o.toString())) {
                if (!validateX(o.toString())) {
                    throw new ValidatorException(message.createMessage("Некорректное значение X!"));
                }
            }
        }
        catch (NullPointerException e){
            throw new ValidatorException(message.createMessage("Введите значение!"));
        }
    }
}
