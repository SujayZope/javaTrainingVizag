package infinite.EnrollPharmacy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("infinite.EnrollPharmacy.PinCodeValidator")
public class PinCodeValidator implements Validator {
	private static final String Zipcode_pattern = "\\d{6}";

	private Pattern pattern;
	private Matcher matcher;
	
	public PinCodeValidator(){
		  pattern = Pattern.compile(Zipcode_pattern);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("ZipCode Validation failed...", 
						"Pin code Contains only 6 Digit.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	}

}
