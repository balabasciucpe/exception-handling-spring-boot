package com.balabasciuc.exceptionhandling.exception_handling.Repository;

import com.balabasciuc.exceptionhandling.exception_handling.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
