package kr.ac.Kopo.lsw.bookmarket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import kr.ac.Kopo.lsw.bookmarket.validator.BookValidator;
import kr.ac.Kopo.lsw.bookmarket.validator.UnitsInStockValidator;


@Configuration
public class ValidationConfig {
	
	@Autowired
	UnitsInStockValidator unitsInStockValidator;
	
	@Bean
    public BookValidator bookValidator() {
		BookValidator bookValidator = new BookValidator();       
		
		bookValidator.springValidators.add(unitsInStockValidator);
		
		
        return bookValidator;
    }
	
}
