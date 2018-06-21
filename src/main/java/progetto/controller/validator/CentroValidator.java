package progetto.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import progetto.model.Centro;
@Component
public class CentroValidator implements Validator {


	@Override
	public void validate(Object o, Errors errors) {
			 
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "indirizzo", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telefono", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "capienzaMax", "required");
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Centro.class.equals(clazz);
	}
}