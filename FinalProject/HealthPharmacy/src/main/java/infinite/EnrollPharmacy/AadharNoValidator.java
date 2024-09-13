package infinite.EnrollPharmacy;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("infinite.EnrollPharmacy.AadharNoValidator")
public class AadharNoValidator implements Validator {

	private static final String aadhar_pattern = "\\d{12}";

	private Pattern pattern;
	private Matcher matcher;
	
	public AadharNoValidator(){
		  pattern = Pattern.compile(aadhar_pattern);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("Aadhar No Validation...", 
						"Aadhar Card No Is Invalid.Please Enter All 12 Digit");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	


	}

}
