package net.joyce.departmentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException{
    public final static String errorMessage = "Employee with %s = %s can not be found";
    public DepartmentNotFoundException(String fieldName, String fieldValue) {
        super(String.format(errorMessage, fieldName, fieldValue));
    }
}

