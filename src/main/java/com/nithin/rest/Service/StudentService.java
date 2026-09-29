package com.nithin.rest.Service;

import com.nithin.rest.Model.Student;
import com.nithin.rest.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepo;


    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //=============Create==================
    public Student createStudent(Student student){
        return studentRepo.save(student);
    }

    //===============Read=================
    public List<Student> getStudents(){
        return studentRepo.findAll();
    }
    public Optional<Student> getStudentById(int rollNo){
        return studentRepo.findById(rollNo);

    }

    //=============Update=============
    public Optional<Student> updateStudent(int rollNo,Student student) {
        Optional<Student> existingStudent = studentRepo.findById(rollNo);
        if (existingStudent.isEmpty()) {
            return Optional.empty();
        }
        student.setRollNo(rollNo);
        return Optional.of(studentRepo.save(student));
    }

    //==========DELETE===================
    public boolean deleteStudent(int rollNo){
        if(!studentRepo.existsById(rollNo)){
            return false;
        }
        studentRepo.deleteById(rollNo);
        return true;

    }







}
