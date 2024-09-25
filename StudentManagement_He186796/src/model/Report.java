/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quyet
 *
 * Report represent report object
 */
public class Report {

    private String studentId;
    private String StudentName;
    private String Course;
    private int totalOfCourse;

    public Report() {
    }

    public Report(String studentId, String StudentName, String Course, int totalOfCourse) {
        this.studentId = studentId;
        this.StudentName = StudentName;
        this.Course = Course;
        this.totalOfCourse = totalOfCourse;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }

    public int getTotalOfCourse() {
        return totalOfCourse;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-25s | %-15s | %-15d", studentId, StudentName, Course, totalOfCourse);
    }

}
