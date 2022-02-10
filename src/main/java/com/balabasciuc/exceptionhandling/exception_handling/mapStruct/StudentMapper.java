package com.balabasciuc.exceptionhandling.exception_handling.mapStruct;

import com.balabasciuc.exceptionhandling.exception_handling.Model.Student;
import com.balabasciuc.exceptionhandling.exception_handling.Model.StudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO toStudentDTO(Student student);
    List<StudentDTO> studentsToStudentsDTO(List<Student> studentList);
    Student dtoToStudents(StudentDTO studentDTO);


}
