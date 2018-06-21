package progetto.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import progetto.model.Attività;

@Component
public class AttivitàValidator implements Validator{


	@Override
	public void validate(Object target, Errors errors) {
		    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required", "Il nome dell'attività è richiesto");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data", "required", "La data dell'attività è richiesta");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orario", "required", "L'ora dell'attività è richiesta");
	}

	
	@Override
	public boolean supports(Class<?> clazz) {
		return Attività.class.equals(clazz);
	}
}
