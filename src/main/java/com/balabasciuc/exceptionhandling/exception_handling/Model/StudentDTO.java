package com.balabasciuc.exceptionhandling.exception_handling.Model;

public class StudentDTO {

    private String studentName;

    public StudentDTO(String studentName) {
        this.studentName = studentName;
    }

    protected StudentDTO() {}

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
