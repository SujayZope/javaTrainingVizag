package infinite.forgetPharmacy;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("infinite.forgetPharmacy.userNameValidator")
public class userNameValidator implements Validator {
	 private static final Pattern PATTERN = Pattern.compile("^[a-z0-9]+$");

	    @Override
	    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
	    	
	    	System.out.println(" validator got called...");
	        String input = (String) value;
	        if (input != null && !PATTERN.matcher(input).matches()) {
	            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username  contains small letters and numbers only.", null);
	            throw new ValidatorException(message);
	        }
	    }

}





