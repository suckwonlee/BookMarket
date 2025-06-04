package kr.ac.Kopo.lsw.bookmarket.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CommonException {
    @ExceptionHandler(value = CategoryException.class)
    private ModelAndView handleException(CategoryException e, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("exception", e.toString());
        mav.addObject("category", e.getCategory());
        mav.addObject("url", request.getRequestURL());
        mav.addObject("errormessage", e.getErrorMessage());

        mav.setViewName("errorCommon");
        return mav;
    }
}
