package com.project.Student.Management.System.controller;

import com.project.Student.Management.System.models.Student;
import com.project.Student.Management.System.services.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;


    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping
    public List<Student> getAll(){
        return service.getAll();
    }
    @PostMapping
    public Student create(@RequestBody Student s){
        return service.save(s);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
@PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id , @RequestBody Student newData ){
        Student existing = service.getById(id);
        if(existing == null){
            return null;
        }
        existing.setUserid(newData.getUserid());
        existing.setEmail(newData.getEmail());
        existing.setCourse(newData.getCourse());
        existing.setYear(newData.getYear());
        return service.save(existing);


}
}