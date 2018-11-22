package com.example.zo0okadev.studentdemoapp.model;

public class Student {

    private int studentId;
    private String studentName, studentImgUrl;

    public Student(int studentId, String studentName, String studentImgUrl) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentImgUrl = studentImgUrl;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentImgUrl() {
        return studentImgUrl;
    }

    public void setStudentImgUrl(String studentImgUrl) {
        this.studentImgUrl = studentImgUrl;
    }
}
