package lab3;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("RValidator")
public class RValidator implements Validator {

    @Override
    public void validate (FacesContext context, UIComponent component, Object o) {
        if (o == null) {
            throw new ValidatorException(new FacesMessage("Enter R."));
        }
        try {
            String strR = o.toString();
            double r = Double.parseDouble(strR);
            if (r < 2 || r > 5) {
                throw new ValidatorException(new FacesMessage("R must be from 2 to 5."));
            }
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage("R is NaN!"));
        }

    }
}