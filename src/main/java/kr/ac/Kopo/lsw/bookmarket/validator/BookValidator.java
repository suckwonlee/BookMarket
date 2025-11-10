package kr.ac.Kopo.lsw.bookmarket.validator;

import java.util.HashSet;
import java.util.Set;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import kr.ac.Kopo.lsw.bookmarket.domain.Book;
import jakarta.validation.ConstraintViolation;

public class BookValidator implements Validator {

	@Autowired
	private jakarta.validation.Validator  beanValidator;	
	
	@Setter
    public Set<Validator> springValidators;

	public BookValidator() { 
	      springValidators = new HashSet<Validator>();		      
	 }

    @Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Set<ConstraintViolation<Object>> violations = beanValidator.validate(target);

		for (ConstraintViolation<Object> violation : violations) {
			String propertyPath = violation.getPropertyPath().toString();
			String message = violation.getMessage();
			errors.rejectValue(propertyPath, "", message);
			
			
		}
		for (Validator validator : springValidators) {
				validator.validate(target, errors);
		}		
	}	
}


