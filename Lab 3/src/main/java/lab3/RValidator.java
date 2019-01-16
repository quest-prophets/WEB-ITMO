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
            FacesMessage msg = new FacesMessage("Enter R.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try {
            String strR = o.toString();
            double r = Double.parseDouble(strR);
            if (r < 2 || r > 5) {
                FacesMessage msg = new FacesMessage("R must be from 2 to 5.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException e) {
            FacesMessage msg = new FacesMessage("R is NaN!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}