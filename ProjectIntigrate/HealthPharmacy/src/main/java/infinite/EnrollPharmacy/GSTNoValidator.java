package infinite.EnrollPharmacy;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("infinite.EnrollPharmacy.GSTNoValidator")
public class GSTNoValidator implements Validator {

	private static final String GSTNo_pattern = "^[0-9]{2}[A-Z]{5}[0-9]{4}"
                                                  + "[A-Z]{1}[1-9A-Z]{1}"
                                                  + "Z[0-9A-Z]{1}$";

	private Pattern pattern;
	private Matcher matcher;
	
	public GSTNoValidator(){
		  pattern = Pattern.compile(GSTNo_pattern);
	}
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		matcher = pattern.matcher(value.toString());
		if(!matcher.matches()){
			
			FacesMessage msg = 
				new FacesMessage("GST No Validation...", 
						"GST No is Invalid.Plese Enter all Letters in Capital");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}
	


	}

}
