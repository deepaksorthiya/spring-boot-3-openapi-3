package com.example.exception;

import com.example.model.ErrorDto;
import com.example.model.FormFieldDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class UserControllerAdviceHandler {

    @Autowired
    private ErrorAttributes errorAttributes;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(MethodArgumentNotValidException exception,
                                                                   WebRequest webRequest) {
        BindingResult bindingResult = exception.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, FormFieldDto> maps = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            String fieldName = fieldError.getField();
            String errorMsg = fieldError.getDefaultMessage();

            if (!maps.containsKey(fieldName)) {
                List<String> errors = new ArrayList<>();
                errors.add(errorMsg);
                FormFieldDto formFieldDto = new FormFieldDto(fieldName, errors);
                maps.put(fieldName, formFieldDto);
            } else {
                List<String> errors = maps.get(fieldName).getErrorMsg();
                errors.add(errorMsg);

                FormFieldDto formFieldDto = new FormFieldDto(fieldName, errors);
                maps.put(fieldName, formFieldDto);
            }

        }

        ErrorDto errorDto = new ErrorDto("Invalid arguments", LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), maps);
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<ErrorDto> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        ErrorDto errorDto = new ErrorDto(illegalArgumentException.getMessage(), LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), null);
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                    WebRequest webRequest) {
        ErrorDto errorDto = new ErrorDto(resourceNotFoundException.getMessage(), LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(), null);
        return new ResponseEntity<ErrorDto>(errorDto, HttpStatus.NOT_FOUND);
    }

}
