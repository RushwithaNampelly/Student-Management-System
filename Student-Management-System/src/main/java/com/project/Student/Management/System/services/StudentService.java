package com.project.Student.Management.System.services;

import com.project.Student.Management.System.models.Student;
import com.project.Student.Management.System.repsitories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repo;
public List<Student> getAll(){
    return repo.findAll();
}
public Student getById(Long id){
    return repo.findById(id).orElse(null);
}
public Student save(Student s){
    return repo.save(s);

}
public void delete(Long id){
repo.deleteById(id);
}
}
