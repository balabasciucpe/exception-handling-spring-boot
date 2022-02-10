package com.balabasciuc.exceptionhandling.exception_handling.Service;


import com.balabasciuc.exceptionhandling.exception_handling.Exceptions.*;
import com.balabasciuc.exceptionhandling.exception_handling.Model.Student;
import com.balabasciuc.exceptionhandling.exception_handling.Model.StudentDTO;
import com.balabasciuc.exceptionhandling.exception_handling.Repository.StudentRepository;
import com.balabasciuc.exceptionhandling.exception_handling.mapStruct.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private StudentMapper studentMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    public void save(StudentDTO studentDTO) {
        if(studentDTO.getStudentName().isEmpty())
        {
            throw new StudentForSaveException();
        }
        Student student = studentMapper.dtoToStudents(studentDTO);
        studentRepository.save(student);
    }

    public Optional<StudentDTO> getById(Long id) {
        return Optional.ofNullable(studentMapper.toStudentDTO(studentRepository.findById(id).orElseThrow(StudentNotFoundException::new)));
    }

    public void delete(Long id) {

        if(checkIfStudentExists(id))
        {
        studentRepository.deleteById(id);
        }
        else throw new NoSuchStudentElementException();
    }

    public List<StudentDTO> getAll()
    {
        List<Student> students = studentRepository.findAll();
        if(students.isEmpty())
        {
            throw new StudentListNotFoundException();
        }
        return studentMapper.studentsToStudentsDTO(students);
    }

    private boolean checkIfStudentExists(Long id)
    {
        return studentRepository.findById(id).isPresent();

    }
}
