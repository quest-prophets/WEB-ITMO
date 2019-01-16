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
            FacesMessage msg = new FacesMessage("Enter Y.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        try {
            String strY = o.toString();
            double y = Double.parseDouble(strY);
            if (y < -5 || y > 5) {
                FacesMessage msg = new FacesMessage("Y must be from -5 to 5.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException e) {
            FacesMessage msg = new FacesMessage("Y is NaN!");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}