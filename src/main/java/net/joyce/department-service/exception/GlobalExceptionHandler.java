package net.javaguides.springbootrestapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*  @ExceptionHandler:
*   在某一个 controller 下面
* @ControllerAdvice:
*   这个 annotation 能够 handle exception globally
* */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
        @ExceptionHandler(net.javaguides.springbootrestapi.exception.ResourceNotFoundException.class)
    public ResponseEntity<net.javaguides.springbootrestapi.exception.ErrorDetails> handleResourceNotFoundException(net.javaguides.springbootrestapi.exception.ResourceNotFoundException exception, WebRequest webRequest) {
        net.javaguides.springbootrestapi.exception.ErrorDetails details = new net.javaguides.springbootrestapi.exception.ErrorDetails(LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND");

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(net.javaguides.springbootrestapi.exception.EmailAlreadyExistsException.class)
    public ResponseEntity<net.javaguides.springbootrestapi.exception.ErrorDetails> handleEmailAlreadyExistsException(net.javaguides.springbootrestapi.exception.EmailAlreadyExistsException exception, WebRequest webRequest) {
            net.javaguides.springbootrestapi.exception.ErrorDetails details = new net.javaguides.springbootrestapi.exception.ErrorDetails(
                    LocalDateTime.now(),
                    exception.getMessage(),
                    webRequest.getDescription(false),
                    "USER_EMAIL_ALREADY_EXISTS"
            );
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }


    /**/
    @ExceptionHandler(Exception.class)
    public ResponseEntity<net.javaguides.springbootrestapi.exception.ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest) {
        net.javaguides.springbootrestapi.exception.ErrorDetails errorDetails = new net.javaguides.springbootrestapi.exception.ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "INTERNAL SERVER ERROR"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        // 拿到所有的 error messages
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        errorList.forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
