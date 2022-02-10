package com.balabasciuc.exceptionhandling.exception_handling.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundException(StudentNotFoundException exception)
    {
        return new ResponseEntity<>("Student wasn't found!", HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NoSuchStudentElementException.class)
    public ResponseEntity<String> noSuchElement(NoSuchStudentElementException noSuchElement)
    {
        return new ResponseEntity<>("We can't find that student for you, check again", HttpStatus.NOT_FOUND);
        //return e.getStackTrake
    }

    @ExceptionHandler(StudentListNotFoundException.class)
    public ResponseEntity<String> studentListException(StudentListNotFoundException studentListException) {
        return new ResponseEntity<>("List can't be showed right now, please try again later!", HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(StudentForSaveException.class)
    public ResponseEntity<String> studentForSave(StudentForSaveException studentSaveException)
    {
        return new ResponseEntity<>("We can save this Entity, please check properties and try again!", HttpStatus.BAD_REQUEST);
    }
}
