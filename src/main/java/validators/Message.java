package validators;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

public class Message {
    public FacesMessage createMessage(String s){
        FacesMessage msg = new FacesMessage(s);
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        return msg;
    }
}
