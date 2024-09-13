package infinite.EnrollPharmacy;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("infinite.EnrollPharmacy.PanCardValidator")
public class PanCardValidator implements Validator {

	private static final String pan_pattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

	private Pattern pattern;
	private Matcher matcher;
	
	public PanCardValidator(){
		  pattern = Pattern.compile(pan_pattern);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("Pan Card No Validation...", 
						"Pan Card No is Invaid.Please Enter All Letters in Capital");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	


	}

}
