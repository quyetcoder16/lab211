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

    private String StudentName;
    private String Course;
    private int totalOfCourse;

    public Report() {
    }

    /**
     *
     * @param StudentName
     * @param Course
     * @param totalOfCourse
     */
    public Report(String StudentName, String Course, int totalOfCourse) {
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

    @Override
    public String toString() {
        return String.format("%-25s | %-15s | %-15d", StudentName, Course, totalOfCourse);
    }

}
