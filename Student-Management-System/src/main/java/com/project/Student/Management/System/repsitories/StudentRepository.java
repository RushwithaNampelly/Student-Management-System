package com.project.Student.Management.System.repsitories;

import com.project.Student.Management.System.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
