package lab3;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("CoordinatesValidator")
public class CoordinatesValidator implements Validator {
    @Override
    public void validate (FacesContext context, UIComponent component, Object value) {
        if (value == null)
            throw new ValidatorException(new FacesMessage("Поле обязательно для ввода."));
        else {
            if (!(value instanceof Double))
                throw new ValidatorException(new FacesMessage("Введите действительное число."));
            else
                if ((Double) value < -5.0 || (Double) value > 5.0)
                    throw new ValidatorException(new FacesMessage("Введите число от -5 до 5."));
        }

    }
}
