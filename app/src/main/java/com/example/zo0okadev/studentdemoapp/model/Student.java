package com.example.zo0okadev.studentdemoapp.model;

public class Student {

    private int studentId;
    private String studentName, studentImgUrl, studentEmail, studentMobile,
            studentGpa, studentClass, studentGender;

    public Student(int studentId, String studentName, String studentImgUrl) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentImgUrl = studentImgUrl;
    }

    public Student(int studentId, String studentName, String studentImgUrl, String studentEmail,
                   String studentMobile, String studentGpa, String studentClass, String studentGender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentImgUrl = studentImgUrl;
        this.studentEmail = studentEmail;
        this.studentMobile = studentMobile;
        this.studentGpa = studentGpa;
        this.studentClass = studentClass;
        this.studentGender = studentGender;
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

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentGpa() {
        return studentGpa;
    }

    public void setStudentGpa(String studentGpa) {
        this.studentGpa = studentGpa;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }


}
