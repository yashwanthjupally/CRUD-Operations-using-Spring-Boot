package com.example.demoForJPA.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String StudentName;
    private String StudentEmail;
    private String studentAddress;

//    Setters
    public void setId(long id) {
        Id = id;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

//    Getters
    public long getId() {
        return Id;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getStudentEmail() {
        return StudentEmail;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

//    Constructor - All Arguments (AllArgs)
    public Student(long id, String studentName, String studentEmail, String studentAddress) {
        Id = id;
        StudentName = studentName;
        StudentEmail = studentEmail;
        this.studentAddress = studentAddress;
    }

//    Constructor - No Arguments (NoArgs)
    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", StudentName='" + StudentName + '\'' +
                ", StudentEmail='" + StudentEmail + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                '}';
    }

}
