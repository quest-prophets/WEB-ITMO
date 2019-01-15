package lab3;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("YValidator")
public class YValidator implements Validator {
    @Override
    public void validate (FacesContext context, UIComponent component, Object o) {
        if (o == null) {
            throw new ValidatorException(new FacesMessage("Enter Y."));
        }
        try {
            String strY = o.toString();
            double y = Double.parseDouble(strY);
            if (y < -5 || y > 5) {
                throw new ValidatorException(new FacesMessage("Enter Y from -5 to 5."));
            }
        } catch (NumberFormatException e) {
            throw new ValidatorException(new FacesMessage("Y is NaN!"));
        }

    }
}