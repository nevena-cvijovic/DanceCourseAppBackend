package rs.ac.bg.fon.njt.dancecourseapp.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import rs.ac.bg.fon.njt.dancecourseapp.dto.ErrorDto;
import rs.ac.bg.fon.njt.dancecourseapp.exception.AppException;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {AppException.class})
    @ResponseBody
    public ResponseEntity<ErrorDto> handleException(AppException ex){
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorDto(ex.getMessage()));
    }
}
