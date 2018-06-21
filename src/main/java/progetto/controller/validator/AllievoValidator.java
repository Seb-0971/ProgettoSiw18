package progetto.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import progetto.model.Allievo;
@Component
public class AllievoValidator implements Validator {


	@Override
	public void validate(Object o, Errors errors) {
			 
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nato", "required");
			 ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "required");
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Allievo.class.equals(clazz);
	}
}