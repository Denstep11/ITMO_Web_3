package converters;

import validators.Message;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("NumberConverter")
public class NumberConverter implements Converter {

    Message message = new Message();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        s = s.replace(",",".");
        try {
            return Float.parseFloat(s);
        }
        catch (NumberFormatException e){
            throw new ConverterException(message.createMessage("Некорректное значение!"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
