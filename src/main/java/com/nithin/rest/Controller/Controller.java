package com.nithin.rest.Controller;

import com.nithin.rest.Model.Student;
import com.nithin.rest.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class Controller {
  private final StudentService service;

   public Controller(StudentService service){
    this.service=service;
  }

//==================CREATE=========================
  @PostMapping
    public ResponseEntity<Student> createStudent(@Valid  @RequestBody Student student) {
      Student savedStudent = service.createStudent(student);
      return ResponseEntity.status(201).body(savedStudent);
  }
  //===================READ=======================
  @GetMapping
  public List<Student> getStudents(){
     return service.getStudents();
  }
  //=================READ BY ID ==========================

    @GetMapping("/{rollNo}")
    public ResponseEntity<Student> getStudentById(@PathVariable int rollNo) {

        return service.getStudentById(rollNo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //=================UPDATE==================================

    @PutMapping("/{rollNo}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable int rollNo,
            @RequestBody Student student) {

        return service.updateStudent(rollNo, student)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //===================DELETE===========================

    @DeleteMapping("/{rollNo}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int rollNo) {

        if (!service.deleteStudent(rollNo)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }


  }


