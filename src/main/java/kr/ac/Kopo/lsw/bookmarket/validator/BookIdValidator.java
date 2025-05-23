package kr.ac.Kopo.lsw.bookmarket.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.Kopo.lsw.bookmarket.Domain.Book;
import kr.ac.Kopo.lsw.bookmarket.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {

    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Book book = null;
        try{
            book = bookService.getBookById(s);
        } catch (RuntimeException e) {
            return true;
        }
        if(book != null){
            return false;
        }
        return true;
    }
}
