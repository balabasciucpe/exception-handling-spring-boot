package com.balabasciuc.exceptionhandling.exception_handling.Controller;

import com.balabasciuc.exceptionhandling.exception_handling.Model.StudentDTO;
import com.balabasciuc.exceptionhandling.exception_handling.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveEntity(@RequestBody StudentDTO studentDTO)
    {
        studentService.save(studentDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(studentService.getById(id).get(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id)
    {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<?> findAll()
    {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.FOUND);
    }
}
