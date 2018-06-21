package progetto.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import progetto.model.Responsabile;


public class ResponsabileValidator implements Validator {

	@Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
       }
	
	 @Override
	    public boolean supports(Class<?> aClass) {
	        return Responsabile.class.equals(aClass);
	    }	

}
