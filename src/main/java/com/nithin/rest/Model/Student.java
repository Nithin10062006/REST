package com.nithin.rest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Student{
    @Id
    @Positive
     private int rollNo;

    @NotBlank
    private String name;

    @NotBlank
     private String branch;

    @NotBlank
     private String college;

    @Min(0)
    @Max(100)
    private double  marks;

    public Student(){

    }
    public Student(int rollNo,String name,String branch,String college,double marks){
        this.rollNo=rollNo;
        this.name=name;
        this.marks=marks;
        this.college=college;
        this.branch=branch;
    }
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

}
